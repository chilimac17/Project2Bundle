package PokerHandTester;

import java.util.ArrayList;

public class HandEvaulator {

    public ArrayList<Card> drawFive(ArrayList<Card> deck){
        ArrayList<Card> hand = new ArrayList<>();
        Deck d1 = new Deck();
        for(int i =0; i < 5; i++){
           hand.add(d1.drawCard(deck));
        }
        return hand;
    }
    
}
