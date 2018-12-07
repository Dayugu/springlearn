package com.gzy.spring.thread.fork;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @Discribe 查找指定类型的文件
 * @Author gzy
 * @Date 2018/12/6 16:09
 *
 * RecursiveAction:不带返回值
 *
 */
public class ForkCheckType extends RecursiveAction{

    private File path;
    private String type;

    public ForkCheckType(File path,String type) {
        this.path = path;
        this.type = type;
    }

    @Override
    protected void compute() {
        //任务集合
        List<ForkCheckType> list = new ArrayList<>();
        File[] files = path.listFiles();
        if (files != null){
            for (File file : files){
                //判断file是否为文件,如果是目录就new FrokCheckType()
                if (file.isDirectory()){
                    ForkCheckType ta = new ForkCheckType(file, this.type);
                    //异步执行任务
                    ta.fork();
                    list.add(ta);
                }else {
                    if (file.getAbsolutePath().endsWith(type) ){
                        System.out.println("目录："+file.getParent()+"中有："+file);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String file ="G:\\files";
        ForkCheckType task = new ForkCheckType(new File(file),"txt");

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        //pool.submit(task);
        Thread.sleep(500);
        //
        System.out.println("异步任务正在执行...");
        //Join方法的主要作用是阻塞当前线程并等待获取结果
        task.join();

        pool.shutdown();
    }

}
