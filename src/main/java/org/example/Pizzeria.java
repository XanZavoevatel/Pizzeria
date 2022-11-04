package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Pizzeria {

    private final LinkedBlockingDeque<String> orders = new LinkedBlockingDeque<>();
    private final ExecutorService service;
    private final long startTime;

    public Pizzeria() throws InterruptedException {
         service = Executors.newFixedThreadPool(2);
         startTime = System.currentTimeMillis();
    }

    void order(String pizzaName) throws InterruptedException {
        orders.offer(pizzaName);
//        long nowTime = System.currentTimeMillis();
//        long deltaTime = nowTime - startTime;
        if (!orders.isEmpty()) {

            service.submit(new Trailer(orders.pollLast()));
        } else {

            System.out.println(orders.pollLast() + " is NOT delivered");
        }
    }

    public ExecutorService getService() {
        return service;
    }

    public long getStartTime() {
        return startTime;
    }
}
