package com.gzy.spring.dataStructure;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/30 16:53
 */
public class Caculater {

    private Stack stack = new Stack();
    private Queue endStr = new ArrayBlockingQueue(30);

    public void inStrChangeToEndStr(String str){


        for (int i = 0; i < str.length();i++){

            char c = str.charAt(i);
            //判断字符是数字还是运算符，如果是运算符，先放入栈，如果是数字则直接放入队列中
            if (c == '/'|| c == '*' || c == '+'|| c == '-'){
                //
                if (stack.isEmpty()){
                    stack.push(c);
                }else if(c == '+' || c == '-'){
                    Object peek = stack.peek();
                    //peek.equals()
                }

            }else if (Character.isDigit(c)){
                endStr.add(c);
            }

        }

    }

}
