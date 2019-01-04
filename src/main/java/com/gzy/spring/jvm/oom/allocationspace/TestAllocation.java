package com.gzy.spring.jvm.oom.allocationspace;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/20 10:17
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;
    /**
     * 设置Eden的大小
     * 参数： -Xms20M -Xmx20M -Xmn10M -XX:PrintGC
     */
    public static void setEden(){
        byte[] allo1, allo2,allo3,allo4;

        allo1 = new byte[2 * _1MB];
        allo2 = new byte[2 * _1MB];
        allo3 = new byte[2 * _1MB];

        allo4 = new byte[4 * _1MB];


    }


    public static void main(String[] args) {
        setEden();
    }

}
