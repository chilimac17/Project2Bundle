package GraphFunction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class salter {
    private FileWriter fileWriter;
    private BufferedWriter bufferWriter;
	private BufferedReader bufferedReader;

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
		bufferedReader = new BufferedReader(new FileReader("Plotter.csv"));
		bufferWriter.write("X " + "," + " Y \n");
		} catch (Exception e) {
			System.out.println("ERROR OCCURED: " + e.toString());
		}
		try {
			while(bufferedReader.readLine() != null) {
				try {
					String line = bufferedReader.readLine();
					/*
					double funcNum = (2*Math.pow(i, 2)) + 5;
					bufferWriter.write(idNum + "," + funcNum + "\n");
					*/
				} catch (Exception e) {
					System.out.println("ERROR OCCURED: " + e.toString());
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	public void test() throws IOException{
		bufferWriter = new BufferedWriter(fileWriter);
		try {
		bufferedReader = new BufferedReader(new FileReader("Plotter.csv"));
		} catch (Exception e) {
			System.out.println("ERROR OCCURED: " + e.toString());
		}
		while(bufferedReader.readLine() != null) {
			String line = bufferedReader.readLine();
			System.out.println(line);
				
			
		}
	} 
}
