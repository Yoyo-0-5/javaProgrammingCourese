package javaHomework.hw1021;

public class PrimeRunnable implements Runnable{

    @Override
    public void run() {
        Prime prime = new Prime(200000);
        Long start = System.currentTimeMillis();
        System.out.println(prime.prime().length);
        Long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }

    public static void main(String[] args) {
        new Thread(new PrimeRunnable()).start();
    }

}
