package com.threads.pool;

/**
 * 固定size的线程池，初始化时，创建size个线程，从BlockingQueue中取线程，执行。
 */
public class CenturyHotel {
    public static void main(String[] args){
        Executor executor =Executor.getFixSizeThreadPool(10);
        System.out.println("开始营业！");

        for (int i=0; i< 20; i++ ){
          Player player = new Player();
          player.setName(""+i);
          executor.submit(player);
        }


        executor.shutdown();
        System.out.println("下班了！");

    }


}
