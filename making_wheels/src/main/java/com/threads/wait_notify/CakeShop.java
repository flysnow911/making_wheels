package com.threads.wait_notify;

/**
 * 生产者，消费者demo。
 * producer,comsumer通过共同的token对像，通过wait,notify方法，线程协作。
 */
public class CakeShop {
    public static void main(String[] args){
        Token token = new Token();

        for(int i=1; i<10;i++){
            (new Thread (new Comsumer(token,i), "thread"+i)).start();
        }

        (new Thread (new Producer(token), "producer")).start();


    }
}
