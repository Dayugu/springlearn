package com.gzy.spring.jvm.oom.gc;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/17 11:06
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] size = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;


        objA = null;
        objB = null;

        System.gc();

    }

}
