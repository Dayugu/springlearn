package com.gzy.spring.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.CreateMode.PERSISTENT;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/7 17:09
 */
public class ZKUtil {

    private static String URL = "39.107.111.156:2181,39.107.111.156:2182,39.107.111.156:2183";
    private static ZooKeeper zooKeeper = null;
    private final static int OUTTIME = 5000;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * 创建连接
     * @throws IOException
     */
    public static void connectCluster() throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(URL, OUTTIME, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                Event.KeeperState state = watchedEvent.getState();
                if (Event.KeeperState.SyncConnected == state){

                    Event.EventType type = watchedEvent.getType();
                    if (type == Event.EventType.None){
                        System.out.println("连接成功.....");
                        countDownLatch.countDown();
                    }
                }
            }
        });

        countDownLatch.await();
    }

    static String path = "/qwer";
    static String value = "text";

    public static void main(String[] args) throws Exception {

        //创建连接
        connectCluster();

        //String s = zooKeeper.create(path, value.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        byte[] data = zooKeeper.getData(path, false, null);
        System.out.println("create result : "+new String(data));

    }




}
