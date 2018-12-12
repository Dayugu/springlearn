package com.gzy.spring.thread.lock;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/11 11:11
 */
public class ReadWriteLockTest {

    private List list;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public ReadWriteLockTest(List list) {
        this.list = list;
    }
    public int get(int k){
        readLock.lock();
        try{
            return (int)list.get(k);
        }finally{
            readLock.unlock();
        }

    }
    public void put(int value){
        writeLock.unlock();
        try{
            list.add(value);
        }finally {
            writeLock.unlock();
        }
    }

}
