package org.example;

import java.util.Scanner;

public class Actions {

    public static void removeOnePigeonFromEveryoneElse(Player[] allPlayers) {
        Player currentPlayer = Datastore.retrieveValue("currentPlayer", Player.class);
        for (Player p : allPlayers) {
            if (p.getPlayerNumber() != currentPlayer.getPlayerNumber()
                    && p.getBench().getNumPigeons() > 0) {
                p.getBench().subtractPigeons(1);
            }
        }
    }

    public static void takeOnePigeonFromAnotherPlayer(Player[] allPlayers) {
        Player currentPlayer = Datastore.retrieveValue("currentPlayer", Player.class);

        Scanner sc = new Scanner(System.in); // 👈 don’t forget System.in
        System.out.println("Who would you like to target?");
        int targetPlayer = sc.nextInt();

        for (Player p : allPlayers) {
            if (p.getPlayerNumber() == targetPlayer && p.getBench().getNumPigeons() > 0) {
                p.getBench().subtractPigeons(1);
                currentPlayer.getBench().addPigeons(1);
                break;
            }
        }
    }

    public static void takeThreePigeonsFromFlock(Player[] allPlayers) {
        Player currentPlayer = Datastore.retrieveValue("currentPlayer", Player.class);
        for (Player p : allPlayers) {
            if (p.getPlayerNumber() == currentPlayer.getPlayerNumber()) {
                p.getBench().addPigeons(3);
            }
        }
    }

    public static void slideLeft(Player[] allPlayers) {
        int numFirstBench = allPlayers[0].getBench().getNumPigeons();
        for (int i=0; i < allPlayers.length - 1; i++) {
                allPlayers[i].getBench().setNumberPigeons(allPlayers[i+1].getBench().getNumPigeons());
            }
        allPlayers[allPlayers.length - 1].getBench().setNumberPigeons(numFirstBench);
    }

    public static void slideRight(Player[] allPlayers) {
        int numLastBench = allPlayers[allPlayers.length - 1].getBench().getNumPigeons();
        for (int i=allPlayers.length -1 ; i > 0; i--) {
            allPlayers[i].getBench().setNumberPigeons(allPlayers[i-1].getBench().getNumPigeons());
        }
        allPlayers[0].getBench().setNumberPigeons(numLastBench);
    }
}
