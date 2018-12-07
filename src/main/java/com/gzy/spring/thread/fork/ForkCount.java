package com.gzy.spring.thread.fork;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/6 16:43
 *
 * RecursiveTask:带有返回值
 *
 */
public class ForkCount extends RecursiveTask<Integer> {

    private File path;

    public ForkCount(File path) {
        this.path = path;
    }

    @Override
    protected Integer compute() {

        int count =0;//文件计数器
        int dirCount = 0;//目录计数器

        List<ForkCount> sumDirs = new ArrayList<>();

        //判断该file是文件还是目录，如果是目录则拆分任务，如果是文件则count++
        if (path != null){
            File[] files = path.listFiles();
            for (File file : files){
                if (file.isDirectory()){
                    sumDirs.add(new ForkCount(file));
                    dirCount++;
                }else {
                    count++;
                }
            }

            System.out.println("目录："+path.getAbsolutePath()+"，文件："+count+"个，目录："+dirCount);

            if (!sumDirs.isEmpty()){
                for (ForkCount forkCount:invokeAll(sumDirs)){
                    //当我们调用ForkJoinTask的fork方法时，程序会调用ForkJoinWorkerThread的pushTask方法异步的执行这个任务，然后立即返回结果。
                    //forkCount.fork();
                    count = count+forkCount.join();
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        String file ="G:\\files";
        ForkCount forkCount = new ForkCount(new File(file));
        // 用一个 ForkJoinPool 实例调度“总任务”
        ForkJoinPool pool = new ForkJoinPool();
        //提交任务到pool执行task
        pool.submit(forkCount);

        System.out.println("invokeall同步执行任务正在执行....");
        //System.out.println("文件总个数："+forkCount.join());
        Thread.sleep(1000);
        pool.shutdown();

    }
}
