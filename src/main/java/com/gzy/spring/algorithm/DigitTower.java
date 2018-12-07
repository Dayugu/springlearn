package com.gzy.spring.algorithm;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/3 10:45
 */
public class DigitTower {

    public static void line(int i ,int n){
        System.out.print(String.format("%3d",i));
        if (i<n){
            line(i+1,n);
            System.out.print(String.format("%3d",i));
        }

    }

    public static void main(String[] args) {
        int n = 9;
        /*for (int i = 1;i<=n;i++){
            int m = 3 * (n - i + 1);
            System.out.print(String.format("%"+String.valueOf(m)+"c",'-'));

            System.out.println();
        }*/

        System.out.println(String.format("% 27d",2));
    }

}
