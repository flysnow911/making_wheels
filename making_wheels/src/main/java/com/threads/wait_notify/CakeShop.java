package com.threads.wait_notify;

public class CakeShop {
    public static void main(String[] args){
        Token token = new Token();

        for(int i=1; i<10;i++){
            (new Thread (new Comsumer(token,i), "thread"+i)).start();
        }

        (new Thread (new Producer(token), "producer")).start();


    }
}
