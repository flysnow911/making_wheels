package com.threads.pool;

public class Player implements Runnable{

    private String name;

    public void setName(String name){
        this.name = name;
    }
    public void run() {
        System.out.println("我是老司机" + name+"。我来释放一下我的内存。");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
