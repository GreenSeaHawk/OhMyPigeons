package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Game Flow:
Initialise game:
1. Ask how many players
2. Create that many players and take 3 random cards from the deck to be in their starting hand.
3. Player 1's turn, are you ready to see your cards? (Y/n)
4. Player 1 then sees the cards and chooses one to use.
5. If the card requires a target player the player is asked which player to target.
6. The card action happens.
7. Repeat the process until a player has 9 pigeons.
 */


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players are playing? (Enter 2-5)");
        int numPlayers = sc.nextInt();
        System.out.printf("You have chosen " + numPlayers + " players\n");

        // Create the players
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i)); // assumes your Player has a constructor Player(int playerNumber)
        }

        // Verify they were created
        for (Player p : players) {
            System.out.println("Created Player " + p.getPlayerNumber());
        }

        Card c1 = new Card(
                "AHHHH!!",
                "All other players return 1 pigeon to the flock",
                () -> Actions.removeOnePigeonFromEveryoneElse(players.toArray(new Player[0])) // <- wrapped in lambda
        );
        Card c2 = new Card(
                "AHHHH!!",
                "All other players return 1 pigeon to the flock",
                () -> Actions.removeOnePigeonFromEveryoneElse(players.toArray(new Player[0])) // <- wrapped in lambda
        );
        Card c3 = new Card(
                "I'll take that",
                "Take 1 pigeon from another player",
                () -> Actions.takeOnePigeonFromAnotherPlayer(players.toArray(new Player[0])) // <- wrapped in lambda
        );
        Card c4 = new Card(
                "AHHHH!!",
                "All other players return 1 pigeon to the flock",
                () -> Actions.removeOnePigeonFromEveryoneElse(players.toArray(new Player[0])) // <- wrapped in lambda
        );
        Card c5 = new Card(
                "AHHHH!!",
                "All other players return 1 pigeon to the flock",
                () -> Actions.removeOnePigeonFromEveryoneElse(players.toArray(new Player[0])) // <- wrapped in lambda
        );
        Card c6 = new Card(
                "I'll take that",
                "Take 1 pigeon from another player",
                () -> Actions.takeOnePigeonFromAnotherPlayer(players.toArray(new Player[0])) // <- wrapped in lambda
        );

        players.get(0).addCardToHand(c1);
        players.get(0).addCardToHand(c2);
        players.get(0).addCardToHand(c3);
        players.get(1).addCardToHand(c4);
        players.get(1).addCardToHand(c5);
        players.get(1).addCardToHand(c6);

        Datastore.saveValue("currentPlayer", players.get(0));
        Player currentPlayer = Datastore.retrieveValue("currentPlayer", Player.class);
        System.out.println("Current player: Player " + currentPlayer.getPlayerNumber());
        System.out.println("Choose a card to play: ");
        currentPlayer.printHand();
        int chosenCard = sc.nextInt();
        currentPlayer.playCard(chosenCard);

        System.out.println("Player 1 pigeons: " + players.get(0).getBench().getNumPigeons());
        System.out.println("Player 2 pigeons: " + players.get(1).getBench().getNumPigeons());
        sc.close();



//    public static boolean allBenchesBelowNine(Bench... benches) {
//        for (Bench bench : benches) {
//            if (bench.getNumPigeons() >= 9) {
//                return false; // at least one bench has 9 or more pigeons
//            }
//        }
//        return true; // all benches have fewer than 9 pigeons
    }
}
