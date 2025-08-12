package com.tap.sahil.demo;

public class multithread {

    static void serveCustomer(String name){
        System.out.println(name+" Service stated... "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" Service finished !! "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1=new Thread(() -> serveCustomer("Customer1"));
        Thread t2=new Thread(() -> serveCustomer("Customer2"));
        Thread t3=new Thread(() -> serveCustomer("Customer3"));

        t1.start();
        t2.start();
        t3.start();
    }
    
}
