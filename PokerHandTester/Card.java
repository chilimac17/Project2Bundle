package PokerHandTester;

public class Card {
    private String suite;
    private int number;

    /**
     * Constructor \n
     * This method takes in suites as String and numerical value set to numbers
     * @param suites
     * @param numbers
     */
    public Card(String suites,int numbers){
        suite = suites;
        number = numbers;
    }
    /**
     * This method is used to get the cards suite
     * @return String suite
     */
    public String getSuite(){
        return suite;
    }
    /**
     * This method sets the suit to card object
     * @param su
     */
    public void setSuite(String su){
        suite = su;
    }
    /**
     * This method is used to get the card number
     * @return int number 
     */
    public int getNumber(){
        return number;  
    }
    /**
     * This method will set the number of a card
     * @param newNum
     */
    public void setNumber(int newNum){
        number = newNum;
    }
    /**
     * Two String Method. Cleaner Presentation
     */
    @Override
    public String toString(){
        return number + " of " + suite;
    }
}
