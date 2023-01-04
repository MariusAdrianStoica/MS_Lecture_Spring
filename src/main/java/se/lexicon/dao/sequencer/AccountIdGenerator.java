package se.lexicon.dao.sequencer;

public class AccountIdGenerator {

    private static int sequencer=0;
    private static final int MAX = 999999; // to generate a random number between the min & max
    private static final int MIN = 100000;

    private static int nextId(){ //only in this class
        return ++sequencer;
    }

    private static int getRandomNumber(){
        return (int) ((Math.random() * (MAX-MIN)) + MIN); //it generates double -> we need int
    }

    public static long generateAccountNumber(){
        String result= nextId()+ "" + getRandomNumber(); //concat nextID with a random number
        return Long.parseLong(result);
    }
}
