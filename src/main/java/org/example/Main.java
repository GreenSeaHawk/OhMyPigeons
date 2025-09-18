package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("OH MY PIGEONS! How many players? (Enter a number between 2 and 5)");
        int numPlayers = scanner.nextInt();

        Bench[] benches = new Bench[numPlayers];

        for (int i = 0; i < numPlayers; i++) {2
            benches[i] = new Bench(i + 1);
        }
        System.out.println("There are " + numPlayers + " players");
        int playerTurn = 1;
        while (allBenchesBelowNine(benches)) {
            System.out.println("It's player " + playerTurn + "'s turn");
            System.out.println();
        }



    }
    public static boolean allBenchesBelowNine(Bench... benches) {
        for (Bench bench : benches) {
            if (bench.getNumPigeons() >= 9) {
                return false; // at least one bench has 9 or more pigeons
            }
        }
        return true; // all benches have fewer than 9 pigeons
    }
}
