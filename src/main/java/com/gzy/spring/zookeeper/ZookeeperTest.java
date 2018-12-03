package com.gzy.spring.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/2 13:34
 */
public class ZookeeperTest {


    private static final Logger logger = LoggerFactory.getLogger(ZookeeperTest.class);

    private  static final String CONNECT_IP="39.107.111.156:2181";

    private  static final int SESSION_OUTTIME = 5000;

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zookeeper;

    //测试路径
    static String nodeName ="/test";
    static String nodeData ="data";

    static String childNode = "/test/child";
    static String childData = "child";

    static String cascadeCreate= "/fir/seond/third";
    static String cascadeCreate2="/cas/f/s/d";

    static String modifyData = "modify";

    static String cascadeNode = "/parent/child";

    public static void main(String[] args) throws  Exception{
        //创建连接
        createConnect();

        //常用指令测试
        //----------------------------------------------------------
        //cascadeTest();
        singleTest();
        //关闭zookeeper连接
        zookeeper.close();

    }



    /**
     * 级联创建节点
     * @param nodePath
     * @param data
     * @param zooKeeper
     * @return
     */
    public static boolean cascadeCreateNode(String nodePath, String data , ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        System.out.println("nodePath:"+nodePath);
        boolean flag = false;
        if (nodePath == null || data == null || zooKeeper == null){
            return flag;
        }
        //先判断是否存在nodepath的节点
        if (zooKeeper.exists(nodePath, false) != null){
            return flag;
        }

        String parentPath = nodePath.substring(0, nodePath.lastIndexOf("/"));
        //判断父节点是否存在，如果存在，则直接创建子节点；如果不存在，先创建父节点再创建自己点（递归调用）；
        if (parentPath.length() > 0){
            cascadeCreateNode(parentPath,data,zooKeeper);
            zooKeeper.create(nodePath,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            flag = true;
        }else {
            zooKeeper.create(nodePath,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            flag = true;
        }

        return flag;
    }

    /**
     * 级联删除
     * @return
     */
    public static boolean cascadeDelete(String nodePath, ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        System.out.println("nodePath: "+nodePath);
        if (zooKeeper.exists(nodePath,false) == null){
            return false;
        }
        //递归删除父级节点
        String parent = nodePath.substring(0,nodePath.lastIndexOf("/"));

        if (parent.length() > 0){
            //删除当前节点
            zooKeeper.delete(nodePath,-1);
            cascadeDelete(parent,zooKeeper);
            return true;
        }else {
            zooKeeper.delete(nodePath,-1);
            return true;
        }


    }

    //级联测试
    public static void cascadeTest(){

        try {
            //boolean flag = cascadeCreateNode(cascadeCreate, "hello", zookeeper);
            boolean flag = cascadeDelete(cascadeCreate, zookeeper);

            System.out.println(flag);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



    /**
     * 创建连接
     * @throws IOException
     * @throws InterruptedException
     */
    public static void createConnect() throws IOException, InterruptedException {
        //创建连接
        zookeeper = new ZooKeeper(CONNECT_IP, SESSION_OUTTIME, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //获取事件状态
                Event.KeeperState state = watchedEvent.getState();
                if(Event.KeeperState.SyncConnected == state){
                    //事件类型
                    Event.EventType type = watchedEvent.getType();
                    if (Event.EventType.None == type){
                        System.out.println("连接成功....");
                        countDownLatch.countDown();
                    }
                }
            }
        });

        countDownLatch.await();

    }

    public static void createNode(String nodeName ,String value) throws KeeperException, InterruptedException {

        zookeeper.create(nodeName,value.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

    }

    public static String getNode(String nodeName) throws KeeperException, InterruptedException {
        byte[] data = zookeeper.getData(nodeName, false, null);
        String value = new String(data);
        System.out.println("getNode:" + value);
        return value;
    }

    public static List<String> getChildNode(String nodename)throws Exception{
        List<String> children = zookeeper.getChildren(nodename, false);

        children.forEach(child ->{
            System.out.println("nodename has child : "+child);
        });

        return children;
    }

    public static void modifyNode(String nodeName,String nodeData) throws  Exception{
        zookeeper.setData(nodeName,nodeData.getBytes(),-1);
    }
    //判断节点是否存在
    public static Stat exists(String nodeName)throws Exception{
        Stat exists = zookeeper.exists(nodeName, false);
        if (exists != null){
            System.out.println("nodeName:"+nodeName+" state: "+exists.toString());
        }else {
            System.out.println("nodeName:"+nodeName +" does not exists");
        }

        return exists;
    }

    /**
     * 不能级联删除
     * @param nodeName
     * @throws Exception
     */
    public static void deleteNode(String nodeName)throws Exception{
        zookeeper.delete(nodeName,-1);
    }


    //单节点测试
    public static  void singleTest() throws Exception {
        //cascadeCreateNode(cascadeNode,null,null);

        //创建节点
        createNode(nodeName,nodeData);

        //创建子节点
        //createNode(childNode,childData);

        //获取节点
        //String node = getNode(nodeName);
        //System.out.println("getNode:"+node);

        //获取子节点
        //getChildNode(nodeName);

        //修改节点内容
        //modifyNode(nodeName,modifyData);
        //String node = getNode(nodeName);

        //删除节点
        //deleteNode(childNode);
        //getChildNode(nodeName);

        //判断node是否存在，不存在则返回null
        //exists(childNode);

        //获取当前节点的子节点
        List<String> childNode = getChildNode("/cas");


    }

    /**
     * 获取当前节点下的所有子节点
     * @param nodePath
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static List<String> getChildren(String nodePath) throws KeeperException, InterruptedException {
        List<String> children = zookeeper.getChildren(nodePath, false);
        children.forEach(node-> System.out.println(node));
        System.out.println("nodepath's "+ nodePath +"children size: "+children.size());
        return children;
    }


}
