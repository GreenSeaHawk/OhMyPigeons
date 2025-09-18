package org.example;

import java.util.Scanner;

public class Actions {
    private static final Scanner scanner = new Scanner(System.in);

    public static void removeOnePigeonFromEveryoneElse(int playerTurn, Bench... benches) {
        for (Bench bench : benches) {
            if (bench.getNumPigeons() > 0 && bench.getPlayer() != playerTurn) {
                bench.subtractPigeons(1);
            }
        }
    }
    public static void takeOnePigeonFromAnotherPlayer(int playerTurn, int targetPlayer, Bench... benches) {
        for (Bench bench : benches) {
            if (bench.getPlayer() == targetPlayer && bench.getNumPigeons() > 0) {
                bench.subtractPigeons(1);
                for (Bench playerBench : benches) {
                    if (playerBench.getPlayer() == playerTurn) {
                        playerBench.addPigeons(1);
                        break;
                    }
                }

                break;
            }
        }
    }
}
