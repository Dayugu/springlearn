package com.gzy.spring.thread.base;

import javax.sound.midi.Soundbank;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/12 11:17
 */
public class StopThread  {

    public static void main(String[] args) {
        OneThread thread = new OneThread();
        thread.start();
        try {
            System.out.println("按任意键停止线程");
            Thread.sleep(1000);
            thread.interrupt();

            thread.join();
            System.out.println("线程已退出");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class OneThread extends Thread{
        public void run(){

            while(!Thread.currentThread().isInterrupted()){
                try {
                    Thread.sleep(2000);
                    System.out.println("thread is sleep.....中断标志位："+Thread.currentThread().isInterrupted());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("thread is running.....中断标志位："+Thread.currentThread().isInterrupted());
           }
        }
    }



}

