package PokerHandTester;


public class Tester {
    public static void main(String[] args){
        /**
         * Creating Hand Evaluator object and calling test method. Number of runs is the input adjustable.
         */
        HandEvaluator n1 = new HandEvaluator();
        n1.testAll(10000);
    }
    
}
