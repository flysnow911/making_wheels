package com.threads.pool;

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
