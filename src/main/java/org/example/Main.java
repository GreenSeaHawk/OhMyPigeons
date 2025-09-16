package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Bench bench = new Bench(1);

        System.out.println(bench.getNumPigeons());
    }
}
