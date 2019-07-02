package com.threads.wait_notify;

import lombok.Data;
import lombok.ToString;

@Data
public class Comsumer implements Runnable {
    private Token token;
    private int num;

    public Comsumer(Token token,int num){
        this.token = token;
        this.num=num;
    }
    public void run() {
        System.out.println("I am thread:" + Thread.currentThread().getName()+"; My No is :" + num);

        synchronized (token){
            System.out.println("Token No." + Token.num + ". I must wait.");

            try {
                token.wait();
                System.out.println("My No." +this.num + "; Token No." + Token.num + "; I get cake!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }


}
