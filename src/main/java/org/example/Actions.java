package org.example;

import java.util.ArrayList;
import java.util.List;
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Who would you like to take a pigeon from?");
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

    public static void takeTwoGiveOnePigeon(Player[] allPlayers) {
        Player currentPlayer = Datastore.retrieveValue("currentPlayer", Player.class);

        Scanner sc = new Scanner(System.in);
        System.out.println("Who would you like to give a pigeon to? (from the flock)");
        int targetPlayer = sc.nextInt();

        for (Player p : allPlayers) {
            if (p.getPlayerNumber() == targetPlayer) {
                p.getBench().addPigeons(1);
                currentPlayer.getBench().addPigeons(2);
                break;
            }
        }
    }

    public static void belowFourTakeTwo(Player[] allPlayers) {
        for (Player p : allPlayers) {
            if (p.getBench().getNumPigeons() <= 3) {
                p.getBench().addPigeons(2);
            }
        }
    }

    public static void allTakeOne(Player[] allPlayers) {
        for (Player p : allPlayers) {
            p.getBench().addPigeons(1);
        }
    }

    public static void swapBench(Player[] allPlayers) {
        Player currentPlayer = Datastore.retrieveValue("currentPlayer", Player.class);
        int currentPlayerBench = currentPlayer.getBench().getNumPigeons();
        Scanner sc = new Scanner(System.in);
        System.out.println("Who would you like to swap benches with?");
        int targetPlayerNum = sc.nextInt();
        Player targetPlayer = allPlayers[targetPlayerNum -1];
        int targetPlayerBench = targetPlayer.getBench().getNumPigeons();
        currentPlayer.getBench().setNumberPigeons(targetPlayerBench);
        targetPlayer.getBench().setNumberPigeons(currentPlayerBench);
    }

    public static void takeOneFromAll(Player[] allPlayers) {
        Player currentPlayer = Datastore.retrieveValue("currentPlayer", Player.class);
        for (Player p : allPlayers) {
            if (p.getPlayerNumber() != currentPlayer.getPlayerNumber()
                    && p.getBench().getNumPigeons() > 0) {
                p.getBench().subtractPigeons(1);
                currentPlayer.getBench().addPigeons(1);
            }
        }
    }

    public static void takeTwoFromMost(Player[] allPlayers) {
        int max = 0;

        // Find max
        for (Player p : allPlayers) {
            int pigeons = p.getBench().getNumPigeons();
            if (pigeons > max) {
                max = pigeons;
            }
        }

        List<Player> result = new ArrayList<>();
        for (Player p : allPlayers) {
            if (p.getBench().getNumPigeons() == max) {
                result.add(p);
            }
        }

        if (result.size() > 1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Multiple players have the most pigeons, " +
                    "which of the following players would you like to lose 3 pigeons?");
            for (Player p: result) {
                System.out.println("Player " + p.getPlayerNumber());
            }
            int targetPlayer = sc.nextInt();
            allPlayers[targetPlayer -1].getBench().subtractPigeons(3);
        } else {
            result.get(0).getBench().subtractPigeons(3);
        }
    }

    public static void onePlayerLoseTwo(Player[] allPlayers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Who would you like to lose 2 pigeons?");
        int targetPlayer = sc.nextInt();

        for (Player p : allPlayers) {
            if (p.getPlayerNumber() == targetPlayer) {
                p.getBench().subtractPigeons(2);
            }
        }
    }

}
