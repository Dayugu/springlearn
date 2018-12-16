package com.gzy.spring.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆内存溢出异常
 */
public class HeapOCM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }

    }

}
