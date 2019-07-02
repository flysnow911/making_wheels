package com.threads.wait_notify;

public class Producer implements Runnable{
    private Token token;

    public Producer(Token token){
        this.token = token;
    }


    public void run() {
        System.out.println("I am producer. I am busy producing cakes!");
        int i = 1;
        while(i<10){
            try {
                System.out.println("making cake No." + i);

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Token.num = i;

            synchronized (token){
                System.out.println("finish cake No." + i + ". I need notify customer no." + i);
                token.notify();
                i++;
            }


        }


    }
}
