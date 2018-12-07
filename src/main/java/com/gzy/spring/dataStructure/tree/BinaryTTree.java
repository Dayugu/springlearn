package com.gzy.spring.dataStructure.tree;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/27 15:51
 */
public interface BinaryTTree<T> {

    boolean isEmpty();
    int count();
    void inOrderTrverce();//中根非递归遍历
    void preOrder();//先根遍历

}
