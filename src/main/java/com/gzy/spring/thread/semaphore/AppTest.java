package com.gzy.spring.thread.semaphore;

import com.gzy.spring.thread.tools.SleepTools;

import java.sql.Connection;
import java.util.Random;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/7 15:37
 */
public class AppTest {

    private static DBConnectPool pool = new DBConnectPool();

    static class BusiConnect extends Thread{

        @Override
        public void run() {
            Random random = new Random();//随机连接时间，让每个连接是的时间都不一样
            long start = System.currentTimeMillis();
            try {
                //从连接池中获取连接
                Connection connection = pool.browserConnect();
                System.out.println("线程："+Thread.currentThread().getId()+" 获取连接时间："+(System.currentTimeMillis()-start));
                SleepTools.ms(random.nextInt(100)+100);
                //业务实现

                //归还连接
                pool.returnConnect(connection);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0 ;i < 50;i++){
            Thread thread = new BusiConnect();
            thread.start();
        }



    }


}
