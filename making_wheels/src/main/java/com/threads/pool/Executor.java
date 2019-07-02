package com.threads.pool;

public class Executor {

    private  static FixSizeThreadPool fixSizeThreadPool;

    public  static Executor getFixSizeThreadPool(int size){

        Executor executor = new Executor();
        fixSizeThreadPool =FixSizeThreadPool.getPool(size);
        return executor;
    }

    public void submit(Runnable runnable){
        fixSizeThreadPool.doExecute(runnable);
    }

    public void shutdown(){
        fixSizeThreadPool.shutdown();
    }

}
