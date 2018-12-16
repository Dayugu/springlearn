package com.gzy.spring.jvm.oom;

/**
 * 创建线程导致内存溢出
 */
public class JVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }
    public void stackLeakByThread(){

        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }

    }
    public static void main(String[] args) {
        JVMStackOOM stackOOM = new JVMStackOOM();
        stackOOM.stackLeakByThread();
    }

}
