package PokerHandTester;
import java.util.ArrayList;
import java.util.Collections;

public class HandEvaluator {
    /**
     * This method will take the first 5 card objects from the array list and add them to another array list.
     * This method is made to replicate drawing 5 cards and adding them to your hand. 
     * @param deck
     * @return ArrayList<Card> hand
     */
    public ArrayList<Card> drawFive(ArrayList<Card> deck){
        ArrayList<Card> hand = new ArrayList<>();
        Deck d1 = new Deck();
        for(int i =0; i < 5; i++){
           hand.add(d1.drawCard(deck));
        }
        return hand;
    }
    /**
     * This method is used to check if a array of card objects has a pair in it. The method will either return a zero or one. If 
     * it returns zero then there is no pair present. If it returns one then a pair is present.
     * @param hand
     * @return int hit
     */
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
    /**
     * This method will conduct the test independently. The number of trials is adjustable. Create the arrays that will store the cards in hand and the deck. 
     * This method will run in a for loop based on trials input and will create a deck, add cards to it, shuffle it. After it uses the matchCheck method to return 
     * a 0 or 1. Result will add up all the numbers through out the loop and then divide by the number trials and multiplied by 100 to get your percent. 
     * @param trials
     * @return double result
     */
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
    /**
     * This method is used to check if a array of card objects has two pairs in it. The method will either return a zero or one. If 
     * it returns zero then there are no two pair present. If it returns one then two pairs are present.
     * @param hand
     * @return int hit
     */
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
    /**
     * This method will conduct the test independently. The number of trials is adjustable. Create the arrays that will store the cards in hand and the deck. 
     * This method will run in a for loop based on trials input and will create a deck, add cards to it, shuffle it. After it uses the matchCheckTwoPair method to return 
     * a 0 or 1. Result will add up all the numbers through out the loop and then divide by the number trials and multiplied by 100 to get your percent. 
     * @param trials
     * @return double result
     */
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
    /**
     * This method is used to check if a array of card objects has 3 pairs in it. The method will either return a zero or one. If 
     * it returns zero then there are no 3 pairs present. If it returns one then three pairs are present.
     * @param hand
     * @return int hit
     */
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
    /**
     * This method is created to return the number of a three of a kind in a hand. If the three of a kind is found then it will return that number.
     * if not it will just return 0.
     * @param hand
     * @return int num
     */
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
    /**
     * This method will conduct the test independently. The number of trials is adjustable. Create the arrays that will store the cards in hand and the deck. 
     * This method will run in a for loop based on trials input and will create a deck, add cards to it, shuffle it. After it uses the matchCheck3 method to return 
     * a 0 or 1. Result will add up all the numbers through out the loop and then divide by the number trials and multiplied by 100 to get your percent. 
     * @param trials
     * @return double result
     */
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
    /**
     * This method is used to check if a array of card objects has 4 pairs in it. The method will either return a zero or one. If 
     * it returns zero then there are no 4 pairs present. If it returns one then 4 pairs are present.
     * @param hand
     * @return int hit
     */
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
    /**
     * This method will conduct the test independently. The number of trials is adjustable. Create the arrays that will store the cards in hand and the deck. 
     * This method will run in a for loop based on trials input and will create a deck, add cards to it, shuffle it. After it uses the matchCheck4 method to return 
     * a 0 or 1. Result will add up all the numbers through out the loop and then divide by the number trials and multiplied by 100 to get your percent. 
     * @param trials
     * @return double result
     */
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
    /**
     * This method is used to check if a array of card objects has a flush in it. The method will either return a zero or one. If 
     * it returns zero then there is no flush present. If it returns one then there is a flush present.
     * @param hand
     * @return int hit
     */
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
    /**
     * This method will conduct the test independently. The number of trials is adjustable. Create the arrays that will store the cards in hand and the deck. 
     * This method will run in a for loop based on trials input and will create a deck, add cards to it, shuffle it. After it uses the flushCheck method to return 
     * a 0 or 1. Result will add up all the numbers through out the loop and then divide by the number trials and multiplied by 100 to get your percent. 
     * @param trials
     * @return double result
     */
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
    /**
     * This method is used to check if a array of card objects has a straight in it. The method will either return a zero or one. If 
     * it returns zero then there is no straight present. If it returns one then there is a straight present.
     * @param hands
     * @return int hit
     */ 
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
    /**
     * This method will conduct the test independently. The number of trials is adjustable. Create the arrays that will store the cards in hand and the deck. 
     * This method will run in a for loop based on trials input and will create a deck, add cards to it, shuffle it. After it uses the straightCheck method to return 
     * a 0 or 1. Result will add up all the numbers through out the loop and then divide by the number trials and multiplied by 100 to get your percent. 
     * @param trials
     * @return double result
     */
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
    /**
     * This method is used to check if a array of card objects have a full house in it. The method will either return a zero or one. If 
     * it returns zero then there is no straight present. If it returns one then there is a full house present.
     * @param fiveCard
     * @return double result
     */ 
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
    /**
     * This method will conduct the test independently. The number of trials is adjustable. Create the arrays that will store the cards in hand and the deck. 
     * This method will run in a for loop based on trials input and will create a deck, add cards to it, shuffle it. After it uses the fullHouseCheck method to return 
     * a 0 or 1. Result will add up all the numbers through out the loop and then divide by the number trials and multiplied by 100 to get your percent. 
     * @param trials
     * @return double result
     */
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
    /**
     * **EXTRA CREDIT**
     * This method is used to check if a array of card objects have a royal flush in it. The method will either return a zero or one. If 
     * it returns zero then there is no royal flush present. If it returns one then there is a royal flush present.
     * @param hand
     * @return int hit
     */
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
    /**
     * **EXTRA CREDIT**
     * This method will conduct the test independently. The number of trials is adjustable. Create the arrays that will store the cards in hand and the deck. 
     * This method will run in a for loop based on trials input and will create a deck, add cards to it, shuffle it. After it uses the royalFlushCheck method to return 
     * a 0 or 1. Result will add up all the numbers through out the loop and then divide by the number trials and multiplied by 100 to get your percent. 
     * @param trials
     * @return double result
     */
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
    /**
     * **EXTRA CREDIT**
     * This method is used to check if a array of card objects have a straight flush in it. The method will either return a zero or one. If 
     * it returns zero then there is no straight flush present. If it returns one then there is a straight flush present.
     * @param hand
     * @return int hit
     */
    public int straightFlushCheck(ArrayList<Card> hand){
        int hit = 0; 
        if(flushCheck(hand) == 1){
            if(straightCheck(hand) == 1){
                hit = 1;
            }
        }
        return hit;
    }
    /**
     * **EXTRA CREDIT**
     * This method will conduct the test independently. The number of trials is adjustable. Create the arrays that will store the cards in hand and the deck. 
     * This method will run in a for loop based on trials input and will create a deck, add cards to it, shuffle it. After it uses the straightFlushCheck method to return 
     * a 0 or 1. Result will add up all the numbers through out the loop and then divide by the number trials and multiplied by 100 to get your percent. 
     * @param trials
     * @return double result
     */
    public double straightFlushTest(int trials){
        double result = 0; 
        Deck d1 = new Deck();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < trials; i++){
            deck = d1.addCardsToDeck();
            deck = d1.shuffleDeck(deck);
            hand = drawFive(deck);
            int count = straightFlushCheck(hand);
            result += count; 
        }
        result = (result/trials) * 100;
        return result;
    }

    /**
     * This method is used to test all of the methods in independent trials. Number of runs is adjustable. This method will print out all the results 
     * in percents.
     * @param runs
     */
    public void testAll(int runs){
        System.out.println("Chances of getting a pair in " + runs + " runs: " + pairTest(runs) + "%");
        System.out.println("Chances of getting a 3 of a kind in " + runs + " runs: " + threeOfAKind(runs) + "%");
        System.out.println("Chances of getting 2 pair in " + runs +" runs: " + (twoPairTest(runs) - threeOfAKind(runs)) + "%");
        System.out.println("Chances of getting a full house in " + runs + " runs: " + fullHouseTest(runs) + "%");
        System.out.println("Chances of getting flush in " + runs + " runs: " + flushTest(runs) + "%");
        System.out.println("Chances of getting straight in " + runs + " runs: " + straightTest(runs) + "%");
        System.out.println("Chances of getting a 4 of a kind in " + runs + " runs: " + fourOfAKind(runs) + "%");
        System.out.println("Chances of getting a royal flush in " + runs + " runs: " + royalFlushTest(runs) + "%");
        System.out.println("Chances of getting a straight flush in " + runs + " runs: " + straightFlushTest(runs) + "%");
        /**
         * **EXTRA CREDIT**
         * Using the compliment theory on Returing the percent of getting no pairs as a trial run.
         */
        System.out.println("Chances of getting no pairs in " + runs + " runs: " +(1 - (pairTest(runs)/100)) + "%");

    }
}