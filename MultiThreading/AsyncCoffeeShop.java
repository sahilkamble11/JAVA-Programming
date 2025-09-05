package com.tap.nirjala.demo;

import java.util.concurrent.CompletableFuture;

public class AsyncCoffeeShop {
    public static void main(String[] args) {
        System.out.println("Order placed for coffee ");
        
        CompletableFuture<Void> coffeeready = CompletableFuture.runAsync(()->
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        });
        System.out.println("You keep chatting with your friend...");
        coffeeready.join();
        System.out.println("Enjoy your coffee");
    }
}
