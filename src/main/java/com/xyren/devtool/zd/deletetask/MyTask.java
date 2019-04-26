package com.xyren.devtool.zd.deletetask;

public class MyTask implements Runnable {

    private int id;

    public MyTask(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("delete task running " + id);
    }
}
