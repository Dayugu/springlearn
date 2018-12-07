package com.gzy.spring.dataStructure.stack;


/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/27 15:59
 */
public class LinkStack<T> implements SStack<T> {

    private Node<T> top;

    public LinkStack() {
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void push(T x) {
        if (x!=null){
            this.top = new Node<>(x,this.top);
        }
    }

    @Override
    public T pop() {

        if (this.top == null)
            return null;
        T temp = this.top.data;
        this.top = this.top.next;
        return temp;
    }

    @Override
    public T get() {
        return this.top == null ? null : this.top.data;
    }
}
