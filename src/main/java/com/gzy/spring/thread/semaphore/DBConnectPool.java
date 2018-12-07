package com.gzy.spring.thread.semaphore;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @Discribe 模拟数据库连接池化
 * @Author gzy
 * @Date 2018/12/7 15:18
 */
public class DBConnectPool {

    private final static Integer POOL_SIZE = 10;//定义池子容量
    private final Semaphore useful,unless;//两个指示器，分别表示池子还有可用连接和已用连接
    //存放数据库连接的池子
    private static LinkedList<Connection> connectionLinkedList = new LinkedList<>();

    //初始化数据库连接
    static {
        for(int i = 0; i<POOL_SIZE ;i++){
            connectionLinkedList.addLast(SqlConnectImpl.fetchConnection());
        }
    }

    public DBConnectPool() {
        this.useful = new Semaphore(10);
        this.unless = new Semaphore(0);
    }

    /**
     * 从池中获取连接
     * @return
     */
    public Connection browserConnect() throws InterruptedException {
        useful.acquire();
        Connection connection;
        synchronized (connectionLinkedList){
            connection = connectionLinkedList.removeFirst();
        }
        unless.release();
        return connection;
    }

    /***
     * 归还连接
     * @param connection
     */
    public void returnConnect(Connection connection) throws InterruptedException {
        if (connection != null){
            System.out.println("当前等待连接数："+useful.getQueueLength()+"，可用连接数："+useful.availablePermits());
            unless.acquire();
            synchronized (connectionLinkedList){
                connectionLinkedList.addLast(connection);
            }
            useful.release();
        }
    }


}
