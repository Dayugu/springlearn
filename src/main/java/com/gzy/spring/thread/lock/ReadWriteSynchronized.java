package com.gzy.spring.thread.lock;

import sun.rmi.log.LogInputStream;

import java.util.LinkedList;
import java.util.List;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/11 13:26
 */
public class ReadWriteSynchronized {

    public static void main(String[] args) {
        List list = new LinkedList();
        Thread read = new Thread(new ReadList(list));
        Thread write = new Thread(new WriteList(list));

        read.start();
        write.start();

    }


    static class ReadList implements Runnable{

        private List list;

        public ReadList(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println("ReadList begtin at "+System.currentTimeMillis());
            synchronized (list){
                try{
                    Thread.sleep(1000);
                    System.out.println("list.wait begin at "+ System.currentTimeMillis());
                    list.wait();

                    System.out.println("list wait is over "+System.currentTimeMillis());

                }catch (InterruptedException  e){
                    e.printStackTrace();
                }
            }
            System.out.println("Readlist end at" +System.currentTimeMillis());
        }
    }

    static class WriteList implements Runnable{
        private List list;

        public WriteList(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println("WriteList is begin at "+System.currentTimeMillis());
            synchronized (list){
                System.out.println("getLock at "+System.currentTimeMillis());
                list.notify();
                System.out.println("list.notify() at "+System.currentTimeMillis());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("get out of block at "+System.currentTimeMillis());
            }
            System.out.println("Write list is over"+System.currentTimeMillis());

        }
    }

}
