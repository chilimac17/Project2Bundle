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
    public int matchCheck(ArrayList<Card> hand){
        int hit = 0;
        boolean killLoop = false;
        for(int i = 0; i < hand.size() && killLoop == false; i ++){
            for(int j = i+1; j < hand.size(); j++){
                if(hand.get(i).getNumber() == hand.get(j).getNumber()){
                    hit = 1;
                    killLoop = true;
                    break;
                }
            }
        } 
        return hit;
    }
    public int matchCheckTwoPair(ArrayList<Card> hand){
        int hit = 0;
        int pairCount = 0;
        boolean killLoop = false;
        for(int i = 0; i < hand.size() && killLoop == false; i ++){
            for(int j = i+1; j < hand.size(); j++){
                if(hand.get(i).getNumber() == hand.get(j).getNumber()){
                    pairCount ++;
                }
                if(pairCount == 2){
                    hit = 1;
                    killLoop = true;
                    break;
                }
            } 
        } 
        return hit;
    }
    public int matchCheck3(ArrayList<Card> hand){
        int hit = 0;
        boolean killLoop = false;
        for(int i = 0; i < hand.size() && killLoop == false; i ++){
            for(int j = i+1; j < hand.size(); j++){
                for(int k = j+1; k < hand.size(); k++){
                    if(hand.get(i).getNumber() == hand.get(j).getNumber() && hand.get(j).getNumber() == hand.get(k).getNumber()){
                        hit = 1;
                        killLoop = true;
                        break;
                    }
                }
            } 
        }
        return hit;
    }
    public int matchCheck4(ArrayList<Card> hand){
        int hit = 0;
        boolean killLoop = false;
        for(int i = 0; i < hand.size() && killLoop == false; i ++){
            for(int j = i+1; j < hand.size(); j++){
                for(int k = j+1; k < hand.size(); k++){
                    for(int m = k+1;m < hand.size(); m++){
                        if(hand.get(i).getNumber() == hand.get(j).getNumber() && 
                        hand.get(j).getNumber() == hand.get(k).getNumber() && 
                        hand.get(i).getNumber() == hand.get(m).getNumber()){
                            hit = 1;
                            killLoop = true;
                            break;
                        }
                    }
                }
            } 
        }
        return hit;
    }
    public int flushCheck(ArrayList<Card> hand){
        int hit = 0;
        boolean killLoop = false;
        for(int i = 0; i < hand.size() && killLoop == false; i ++){
            for(int j = i+1; j < hand.size(); j++){
                if(hand.get(i).getSuite() != hand.get(j).getSuite()){
                    return hit;
                }

            }
        } 
        return hit = 1;
    }
    public double pairTest(int trials){
        double result = 0;
       
        Deck d1 = new Deck();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < trials; i++){
            deck = d1.addCardsToDeck();
            deck = d1.shuffleDeck(deck);
            hand = drawFive(deck);
            int count = matchCheck(hand);
            result += count; 
        }

        result = (result/trials) * 100;
        return result;
    }
    public double twoPairTest(int trials){
        double result = 0;
        Deck d1 = new Deck();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < trials; i++){
            deck = d1.addCardsToDeck();
            deck = d1.shuffleDeck(deck);
            hand = drawFive(deck);
            int count = matchCheckTwoPair(hand);
            result += count; 
        }

        result = (result/trials) * 100;
        return result;
    }

    public double threeOfAKind(int trials){
        double result = 0; 
        Deck d1 = new Deck();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < trials; i++){
            deck = d1.addCardsToDeck();
            deck = d1.shuffleDeck(deck);
            hand = drawFive(deck);
            int count = matchCheck3(hand);
            result += count; 
        }

        result = (result/trials) * 100;
        return result;
    }
    public double fourOfAKind(int trials){
        double result = 0; 
        Deck d1 = new Deck();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < trials; i++){
            deck = d1.addCardsToDeck();
            deck = d1.shuffleDeck(deck);
            hand = drawFive(deck);
            int count = matchCheck4(hand);
            result += count; 
        }

        result = (result/trials) * 100* 100;
        return result;
    }
    public double flushTest(int trials){
        double result = 0; 
        Deck d1 = new Deck();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < trials; i++){
            deck = d1.addCardsToDeck();
            deck = d1.shuffleDeck(deck);
            hand = drawFive(deck);
            int count = flushCheck(hand);
            result += count; 
        }

        result = (result/trials) * 100;
        return result;
    }
    
}
