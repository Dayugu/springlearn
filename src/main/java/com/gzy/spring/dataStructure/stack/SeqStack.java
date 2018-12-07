package com.gzy.spring.dataStructure.stack;

import java.util.Stack;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/30 15:28
 */
public class SeqStack<T> implements SStack<T> {

    private Object element[];
    private int top;

    public SeqStack(int size) {
        this.element = new Object[Math.abs(size)];
        this.top = -1;
    }

    public SeqStack() {
        this(64);
    }

    @Override
    public boolean isEmpty() {
        return this.top ==  -1;
    }

    @Override
    public void push(T x) {
        if (x == null){
            return;
        }
        if (this.top == element.length-1){

            Object[] tempt = this.element;
            this.element = new Object[tempt.length*2];
            for (int i = 0; i <tempt.length; i++)
                this.element[i] = tempt[i];
        }
        this.top++;
        this.element[this.top] = x;

    }

    @Override
    public T pop() {

        return this.top==-1 ? null : (T)this.element[this.top--];
    }

    @Override
    public T get() {
        return this.top==-1 ? null : (T)this.element[this.top];
    }

    public static String isValid(String str){
        SeqStack<String> stack = new SeqStack<>();

        for (int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            switch (c){
                case '(':stack.push(c+"");
                    break;
                case ')':if (stack.isEmpty()|| stack.pop().equals("(")){
                    return "缺少（";
                }
            }
        }
        return (stack.isEmpty()? "":"缺少）");
    }


    public static void main(String[] args) {
        String str = "1*(1+2)+2+)";
        String valid = isValid(str);
        System.out.println(valid);

    }



}
