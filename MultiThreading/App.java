package com.tap.sahil.demo;

public class App 
{
    static void serveCustomer(String name){
        System.out.println(name+" service started ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" service finished !!!");

    }
    public static void main( String[] args )
    {
       serveCustomer("Customer1");
       serveCustomer("Customer2");
       serveCustomer("Customer3");
        
    }
}
