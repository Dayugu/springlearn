package com.gzy.spring.dataStructure.stack;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/27 16:02
 */
public class Node<T> {

    public T data;
    public Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data,null);
    }

    public Node() {
        this(null);
    }
}
