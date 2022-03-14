package PokerHandTester;

public class Card {
    private String suite;
    private int number;

    public Card(String suites,int numbers){
        suite = suites;
        number = numbers;
    }

    public String getSuite(){
        return suite;
    }
    /**
     * 
     * @param su
     */
    public void setSuite(String su){
        suite = su;
    }
    /**
     * This method is used to get the card number
     * @return number from card
     */
    public int getNumber(){
        return number;  
    }
    public void setNumber(int newNum){
        number = newNum;
    }
    @Override
    public String toString(){
        return number + " of " + suite;
    }
}
