package com.tap.sahil.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool 
    {
    static void serveCustomer(String name)
        {
            System.out.println(name+" served by "+Thread.currentThread().getName());
        try 
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ExecutorService service=Executors.newFixedThreadPool(4);
        for(int i=1;i<=5;i++){
            final String customer="customer "+i;
            service.submit(() -> serveCustomer(customer));

        }
        service.shutdown();
    }
    
}
