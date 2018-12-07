package com.gzy.spring.dataStructure.tree;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/27 15:44
 */
public class BinaryNode<T> {

    public T data;
    public BinaryNode<T> left,right;

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data){
        this(data,null,null);
    }

    public BinaryNode(){
        this(null);
    }

    @Override
    public String toString() {
        return "BinaryNode{" + "data=" + data + ", left=" + left+ ", right=" + right + '}';
    }
}
