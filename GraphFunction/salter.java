package GraphFunction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class salter {
	//File Path: ~/Code/GitHub/Project2Bundle/Plotter.csv
    private FileWriter fileWriter;
    private BufferedWriter bufferWriter;
	File inputFile = new File("Plotter.csv");
	private Scanner csvReader;
	

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
		int count = 0;
		try {
		csvReader = new Scanner(inputFile);
		bufferWriter.write("X " + "," + " Y \n");
		} catch (Exception e) {
			System.out.println("ERROR OCCURED: " + e.toString());
		}
		while(csvReader.hasNextLine()){
			
		try {
			String line = csvReader.next();
			int comma = line.indexOf(",");
			if(count >= 1){
				double x = Double.valueOf(line.substring(0,comma));
				double y = Double.valueOf(line.substring(comma+1));
				y = newY(y);
				bufferWriter.write(x + "," + y + "\n");	
			}
			count++;
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
        int addOrSub = rng.nextInt(600) + 1;
        int decision = rng.nextInt(2);
        if(decision == 0){
            y = y + addOrSub;
        }else{
            y = y - addOrSub;
        }
        return y;
    }
}
