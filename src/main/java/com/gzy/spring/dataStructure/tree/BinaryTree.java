package com.gzy.spring.dataStructure.tree;

import com.gzy.spring.dataStructure.stack.LinkStack;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/27 15:44
 */
public class BinaryTree<T> implements BinaryTTree<T>{

    public BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T[] preList,T[] inList) {
        this.root = create(preList,inList,0,0,preList.length);
    }

    /**
     * 根据先根、中根序列创建一棵树
     * @param prelist
     * @param inList
     * @param preStart
     * @param inStart
     * @param n
     * @return
     */
    public BinaryNode<T> create(T[] prelist, T[] inList, int preStart, int inStart, int n){
        if(n <= 0){
            return null;
        }

        T element = prelist[preStart];
        BinaryNode<T> p = new BinaryNode<>(element);
        int i = 0;
        while (i < n && !element.equals(inList[inStart+1]))
            i++;
        System.out.println(p.toString());
        p.left = create(prelist,inList,preStart+1,inStart,i);
        p.right = create(prelist,inList,preStart+1+i,inStart+1+i,n-1-i);
        System.out.println(p.toString());
        return p;
    }


    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void inOrderTrverce() {
        LinkStack<BinaryNode<T>> stack = new LinkStack<>();
        BinaryNode<T> p = this.root;

        while(p != null || !stack.isEmpty()){
            if (p == null ){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                System.out.println("data = "+p);
                p = p.right;
            }
        }
    }

    @Override
    public void preOrder() {
        System.out.println("先根遍历开始：");
        preOrder(root);
        System.out.println("先根遍历结束");
    }

    public void preOrder(BinaryNode<T> p){
        if ( p != null ){
            System.out.println(p.data.toString());
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public static void main(String[] args) {
        String[] preList = {"A","B","D","G","C","E","F"};
        String[] inList = {"D","G","B","A","E","C","F"};
        BinaryTree<String> binaryNode = new BinaryTree<String>(preList,inList);
        binaryNode.preOrder();

    }

}
