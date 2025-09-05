package com.tap.nirjala.demo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolBank {
    static void serveCustomer(String name)
    {
        System.out.println(name+" Served by..."+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ExecutorService service=Executors.newFixedThreadPool(2);

        for(int i =1;i<=5;i++){
            final String customer="Customer"+i;
            service.submit(()->serveCustomer(customer));
        }
        service.shutdown();
    }

}

