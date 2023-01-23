package projectbundle2.PokerHandTester;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    /**
     * This method will add card object to an ArrayList.This method assembles the deck together
     * it will add one of every kind of card each with a different suite
     * @return ArrayList of Card Objects
     */
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
    /**
     * This method is used to simulate shuffling a deck of cards getting a random number of cards.
     *  the most efficent way was to utilize outside tools and use the collections.sort method. 
     * @param createDeck
     * @return ArrayList of card Objects(Shuffled)
     */
    public ArrayList<Card> shuffleDeck(ArrayList<Card> createDeck){
        Collections.shuffle(createDeck);
        return createDeck;
    }
    /**
     * This method replicates drawing a card from a deck. First you will get the first card object at index = 0
     * then it will remove that card from the arraylist(deck).
     * @param deck
     * @return Card Object
     */
    public Card drawCard(ArrayList<Card> deck){
        Card drawnCard = deck.get(0);
        deck.remove(0);
        return drawnCard;
    }
    /**
     * This method is created for testing purposed to make sure information was being stored in the arrays properly.
     * @param list
     */
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