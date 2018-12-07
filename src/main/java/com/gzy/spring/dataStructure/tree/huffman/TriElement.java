package com.gzy.spring.dataStructure.tree.huffman;

/**
 * @Discribe 二叉树的静态三叉链表
 * @Author gzy
 * @Date 2018/11/29 14:14
 */
public class TriElement {

    int data;
    int parent;
    int left;
    int right;

    public TriElement(int data, int parent, int left, int right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "TriElement{" + "data=" + data + ", parent=" + parent + ", left=" + left + ", right=" + right + '}';
    }
}
