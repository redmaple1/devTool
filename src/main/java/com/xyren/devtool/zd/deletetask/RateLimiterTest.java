package com.xyren.devtool.zd.deletetask;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterTest {

    public static void main(String[] args) {

        RateLimiter rateLimiter = RateLimiter.create(2);
        List<MyTask> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            tasks.add(new MyTask(i));
        }

        ExecutorService pool = Executors.newCachedThreadPool();

        for (MyTask task: tasks){
            System.out.println("wait time : " + rateLimiter.acquire());
            pool.execute(task);
        }

        pool.shutdown();
    }

}
