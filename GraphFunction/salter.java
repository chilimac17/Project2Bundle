package GraphFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class salter {
    private FileWriter fileWriter;
    private BufferedWriter bufferWriter;
    //takes in a csv file, loop through +/- random number
    //output csv file 
    //makes bounds configureable
    public salter(){
        try {
			//.csv
			fileWriter = new FileWriter("Salter.csv");
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.toString());
		}
    }
    public void createSaltData() {
		bufferWriter = new BufferedWriter(fileWriter);
		
		try {
		bufferWriter.write("X " + "," + " Y \n");
		} catch (Exception e) {
			System.out.println("ERROR OCCURED: " + e.toString());
		}
		for(int i = 0; i <= 1000; i++ ) {
			try {
				int idNum = i;
				double funcNum = (2*Math.pow(i, 2)) + 5;
				bufferWriter.write(idNum + "," + funcNum + "\n");
			} catch (Exception e) {
				System.out.println("ERROR OCCURED: " + e.toString());
			}
		}
		try {
			bufferWriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
    public double newY(double y){
        Random rng = new Random();
        int addOrSub = rng.nextInt(20);
        int decision = rng.nextInt(2);
        if(decision == 0){
            y = y + addOrSub;
        }else{
            y = y - addOrSub;
        }
        return y;
    }
}
