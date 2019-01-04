package com.gzy.spring.jvm.oom.gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/17 15:22
 */
public class SoftReferenceTest {

    static class User{
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" + "age=" + age + ", name='" + name + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        User user = new User(1,"gzy");

        java.lang.ref.SoftReference<User> softUser = new SoftReference<User>(user);

        user = null;

        System.out.println(softUser.get());
        System.gc();
        System.out.println("after GC");
        System.out.println("softReference user "+softUser.get());

        List<byte[]> list = new ArrayList<>();


        try{
            for (int i = 0; i < 100; i++){
                System.out.println("》》》》》"+softUser.get());
                list.add(new byte[1024*1024]);
            }
        }catch (Throwable e){
            System.out.println("Throwable ......."+softUser.get());
        }





    }

}
