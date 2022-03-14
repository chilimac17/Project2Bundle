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

        d1.printDeck(hand);
    }
    
}
