package com.gzy.spring.dataStructure.stack;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/27 15:58
 */
public interface SStack<T> {

    public boolean isEmpty();

    void push(T x);//入栈

    T pop();//出栈

    T get();//取栈顶元素

}
