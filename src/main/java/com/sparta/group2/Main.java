package com.sparta.group2;


import com.sparta.group2.view.CLI;

public class Main {

    public static void main(String[] args) {

        long start1 = System.nanoTime();

      long end1 = System.nanoTime();

        System.out.println("Time taken: " + (end1 - start1));

        CLI cli = new CLI();
        cli.run();

    }
}
