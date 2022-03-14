package PokerHandTester;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public Deck(){
        
    }
    public ArrayList<Card> addCardsToDeck(){
        ArrayList<Card> newDeck = new ArrayList<Card>(); 
        String[] suiteList = {"SPADES","HEARTS","DIAMONDS","CLUBS"};
        for(int i = 1; i <= 13; i++){
            for(int j = 0; j < suiteList.length; j++){
                Card card = new Card(suiteList[j],i);
                newDeck.add(card);
            }
        }
        return newDeck;
    }
    public ArrayList<Card> shuffleDeck(ArrayList<Card> createDeck){
        Collections.shuffle(createDeck);
        return createDeck;
    }
    public Card drawCard(ArrayList<Card> deck){
        Card drawnCard = deck.get(0);
        deck.remove(0);
        return drawnCard;
    }
    public void printDeck(ArrayList<Card> list){
        for(int i =0; i < list.size(); i++ ){
            /*
            System.out.println(list.get(i).getSuite());
            System.out.println(list.get(i).getNumber());
            */
            System.out.println(list.get(i).toString());
        }
    }
    
}