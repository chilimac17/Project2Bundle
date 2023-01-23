package projectbundle2.PokerHandTester;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Tester {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    public static void main(String[] args){
        /**
         * Creating Hand Evaluator object and calling test method. Number of runs is the input adjustable.
         */
        HandEvaluator n1 = new HandEvaluator();
        //increase runs to get better results
        n1.testAll(10000);
    }
    
}
