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

    //级联创建
    public static void cascadeCreateNode(String nodeName, String parentData ,String childData)throws Exception{
        String[] split = nodeName.split("\\/");
        for(int i = 0; i < split.length; i++ ){
            System.out.println(split[i]);
        }
    }

    public static void main(String[] args) throws  Exception{
        //创建连接
        createConnect();

        //常用指令测试
        //----------------------------------------------------------
        String nodeName ="/test";
        String nodeData ="data";

        String childNode = "/test/child";
        String childData = "child";

        String modifyData = "modify";

        String cascadeNode = "/parent/child";

        cascadeCreateNode(cascadeNode,null,null);

        //创建节点
        //createNode(nodeName,nodeData);

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




    }
}
