package PokerHandTester;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args){
        Deck d1 = new Deck();
        HandEvaulator n1 = new HandEvaulator();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();

        deck = d1.addCardsToDeck();
        deck = d1.shuffleDeck(deck);
        hand = n1.drawFive(deck);
        /*
        d1.printDeck(hand);
        System.out.println(deck.size());

        hand = n1.drawFive(deck);
        d1.printDeck(hand);
        System.out.println(deck.size());
        */
        System.out.println("Chances of getting a pair in blank runs: " + n1.pairTest(10000));
        System.out.println("Chances of getting a 3 of a kind in blank runs: " + n1.threeOfAKind(10000));
        System.out.println("Chances of getting a 4 of a kind in blank runs: " + n1.fourOfAKind(10000));
        System.out.println("Chances of getting 2 pair in blank runs: " + n1.twoPairTest(10000));
        System.out.println("Chances of getting flush in blank runs: " + n1.flushTest(10000));

        

    }
    
}
