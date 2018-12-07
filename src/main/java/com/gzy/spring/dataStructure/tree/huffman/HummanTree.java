package com.gzy.spring.dataStructure.tree.huffman;

/**
 * @Discribe 哈弗曼树
 * @Author gzy
 * @Date 2018/11/29 14:13
 */
public class HummanTree {

    private int leafNum;            //叶子结点的个数
    private TriElement[] huftree;   //huffman树的节点数组

    /**
     * 构造指定权值集合的huffman树
     * @param weight
     */
    public HummanTree(int[] weight) {

        int n = weight.length;  //n个叶子结点
        this.leafNum = n;
        this.huftree = new TriElement[2*n - 1];

        for (int i = 0; i < n;i++){


            this.huftree[i]  = new TriElement(weight[i],0,0,0);

        }





    }
}
