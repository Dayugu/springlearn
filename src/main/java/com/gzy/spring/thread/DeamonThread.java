package com.gzy.spring.thread;

/**
 * @Describe interput()并不是直接中断线程，而是将该线程的中断标志位置为true
 * 但是如果线程抛出InterruptedException，并且在catch中手动执行interrput（）时，线程会被终止
 */
public class DeamonThread {

    public static class UserThread extends Thread{

        public UserThread(String name){
            super(name);
        }

        @Override
        public void run(){
            
            while (!isInterrupted()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" flag is "+isInterrupted());

                    interrupt();

                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" is run");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        UserThread userThread = new UserThread("UserThread");

        userThread.start();
        Thread.sleep(500);

        userThread.interrupt();
    }

}
