package PokerHandTester;

import java.util.ArrayList;
import java.util.Collections;

public class HandEvaulator {
    //draw 5
    public ArrayList<Card> drawFive(ArrayList<Card> deck){
        ArrayList<Card> hand = new ArrayList<>();
        Deck d1 = new Deck();
        for(int i =0; i < 5; i++){
           hand.add(d1.drawCard(deck));
        }
        return hand;
    }
    //one pair 
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
    //two pair
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
    //three pair
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
    //return number of three of a kind 
    public int returnThreeOfAKindNum(ArrayList<Card> hand){
        int num = 0;
        boolean killLoop = false;
        for(int i = 0; i < hand.size() && killLoop == false; i ++){
            for(int j = i+1; j < hand.size(); j++){
                for(int k = j+1; k < hand.size(); k++){
                    if(hand.get(i).getNumber() == hand.get(j).getNumber() && hand.get(j).getNumber() == hand.get(k).getNumber()){
                        num = hand.get(i).getNumber(); 
                        killLoop = true;
                        break;
                    }
                }
            } 
        }
        return num;
    }
    //four of a kind
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
    //checks for flush
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
    //straight test 
    public int straightCheck(ArrayList<Card> hands){
        int hit = 0;
        int count = 0;
        ArrayList<Integer> handVals = new ArrayList<>();
        for(int i = 0; i < hands.size(); i++){
            handVals.add(hands.get(i).getNumber());
        }
        Collections.sort(handVals);
        for(int i = 0; i < handVals.size(); i++){
            if(handVals.get(i+1) - handVals.get(i) == 1 ){
                count++;
                if(count == 4){
                    hit = 1;
                    break;
                }
            }else{
                break;
            }
        }
        return hit;
    }
    //testing methods
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

        result = (result/trials) * 100;
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
    public double fullHouseCheck(ArrayList<Card> fiveCard){
        int hit = 0;
        int threeOf = 0; 
        ArrayList<Card> hand2 = new ArrayList<>();
        if(matchCheck3(fiveCard) == 1){
            threeOf = returnThreeOfAKindNum(fiveCard);
            for(int i = 0; i < fiveCard.size(); i++){
                if(fiveCard.get(i).getNumber() != threeOf){
                    hand2.add(fiveCard.get(i));
                }
            }
            if(matchCheck(hand2) == 1){
                hit = 1;
            }
        }
        return hit;
    }
    public double fullHouseTest(int trials){
        double result = 0; 
        Deck d1 = new Deck();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < trials; i++){
            deck = d1.addCardsToDeck();
            deck = d1.shuffleDeck(deck);
            hand = drawFive(deck);
            int count =(int)fullHouseCheck(hand);
            result += count; 
        }
        result = (result/trials) * 100;
        return result;
    }
    public double straightTest(int trials){
        double result = 0; 
        Deck d1 = new Deck();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < trials; i++){
            deck = d1.addCardsToDeck();
            deck = d1.shuffleDeck(deck);
            hand = drawFive(deck);
            int count =(int)straightCheck(hand);
            result += count; 
        }
        result = (result/trials) * 100;
        return result;
    }
    public double royalFlushTest(int trials){
        double result = 0; 
        Deck d1 = new Deck();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < trials; i++){
            deck = d1.addCardsToDeck();
            deck = d1.shuffleDeck(deck);
            hand = drawFive(deck);
            int count = royaleFlushCheck(hand);
            result += count; 
        }
        result = (result/trials) * 100;
        return result;
    }
    public int royaleFlushCheck(ArrayList<Card> hand){
        int hit = 0;
        int count = 0;
        ArrayList<Integer> handVals = new ArrayList<>();
        int[] royalCheck = {10,11,12,13,1};
        for(int i = 0; i < hand.size(); i++){
            handVals.add(hand.get(i).getNumber());
        }
        Collections.sort(handVals);
        for(int i = 0; i < handVals.size(); i++){
            if(handVals.get(i) == royalCheck[i]){
                count++;
                if(count == 5){
                    hit = 1;
                    break;
                }
            }else{
                break;
            }
        }
        return hit;
       
    }
    //straight flush
    public void testAll(int runs){
        System.out.println("Chances of getting a pair in " + runs + " runs: " + pairTest(runs) + "%");
        System.out.println("Chances of getting a 3 of a kind in " + runs + " runs: " + threeOfAKind(runs) + "%");
        System.out.println("Chances of getting 2 pair in " + runs +" runs: " + twoPairTest(runs) + "%");
        System.out.println("Chances of getting a full house in " + runs + " runs: " + fullHouseTest(runs) + "%");
        System.out.println("Chances of getting flush in " + runs + " runs: " + flushTest(runs) + "%");
        System.out.println("Chances of getting straight in " + runs + " runs: " + straightTest(runs) + "%");
        System.out.println("Chances of getting a 4 of a kind in " + runs + " runs: " + fourOfAKind(runs) + "%");
        System.out.println("Chances of getting a royal flush in " + runs + " runs: " + royalFlushTest(runs) + "%");
    }
}
