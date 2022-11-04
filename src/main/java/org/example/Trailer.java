package org.example;

public class Trailer implements Runnable{

    private final String namePizza;

    public Trailer(String namePizza) {
        this.namePizza = namePizza;
    }

    @Override
    public void run() {
        try {

            work();

            System.out.println(namePizza + " is delivered");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void work() throws InterruptedException {
        Thread.sleep(500);
    }
}
