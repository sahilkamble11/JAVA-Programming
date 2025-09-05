package com.tap.nirjala.demo;

class dishMaker extends Thread
    {
        private String dish;

    public dishMaker(String dish)
    {
        this.dish=dish;
    }

    public void run()
    {
        System.out.println(dish+"Preparation statred by "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The dish is ready");
    }
}

public class MultiChefRestaurant {
    public static void main(String[] args) {
        Thread chef1=new dishMaker("Maggie");
        Thread chef2=new dishMaker("Masala maggie");
        Thread chef3=new dishMaker("Cheese maggie");

        chef1.start();
        chef2.start();
        chef3.start();
    }
    
}
