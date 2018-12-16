package com.gzy.spring.jvm.oom;

public class JVMStackSOF {
    static class StackSof{
        int i = 0;

        public void stackOverFlower(){
            i++;
            stackOverFlower();
        }


    }
    public static void main(String[] args) {

        StackSof stackSof = new StackSof();

        try{
            stackSof.stackOverFlower();

        }catch (Throwable e){
            System.out.println("i length:"+stackSof.i);
            throw e;
        }
    }
}
