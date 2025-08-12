package com.tap.sahil.demo;
import java.util.concurrent.CompletableFuture;

public class DemoCompletableFuture {
    
    public static void main(String[] args) {
        System.out.println("Order placed for coffee...");

        CompletableFuture<Void> coffeeReady = CompletableFuture.runAsync(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println("Coffee is ready!");
        });

        System.out.println("You keep chatting with your friend...");
        coffeeReady.join(); 
        System.out.println("Enjoy your coffee!");
    }
}
