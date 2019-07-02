package com.threads.pool;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class FixSizeThreadPool {
    private int coreSize;
    private volatile AtomicInteger idelSize;
    private LinkedList<Worker> workers=new LinkedList<Worker>();
    private BlockingQueue<Runnable> queue;
    private volatile boolean isShutdown = true;

    //上班,准备小姐姐
    public static FixSizeThreadPool getPool(int coreSize){
        FixSizeThreadPool pool = new FixSizeThreadPool();
        pool.coreSize = coreSize;
        pool.idelSize = new AtomicInteger(coreSize);


        pool.queue = new LinkedBlockingQueue<Runnable>();
        pool.isShutdown = false;
        for(int i=0; i<coreSize;i++){
            Worker worker = new Worker(pool,"Thread" + i);
            worker.start();
            pool.workers.add(worker);

        }

        return pool;
    }

    public void addTask(Runnable task){
        if(idelSize.get()>0 && !isShutdown){

        }else{

        }
    }

    public void doExecute(Runnable task){
        this.queue.offer(task);

    }

    static class Worker extends Thread{
        String name;

        FixSizeThreadPool pool;
        public Worker(FixSizeThreadPool pool, String name){
            this.pool = pool;
            setName(name);

        }
        Runnable task;
        public void run(){
            while(pool.queue.size()>0 || pool.isShutdown==false){
                try {
                    if(pool.isShutdown==false){
                        task = pool.queue.take();

                    }else{
                        task = pool.queue.poll();
                    }
                    if(task!=null){
                        task.run();
                        System.out.println("小姐姐"+ Thread.currentThread().getName() + "服务完毕。欢迎下次再来！！");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
       }
    }

    public void shutdown(){
        this.isShutdown = true;
        for(Worker worker : workers){
            if(worker.getState().equals(Thread.State.WAITING) || worker.getState().equals(Thread.State.BLOCKED)){
                worker.interrupt();
            }
        }
    }



}
