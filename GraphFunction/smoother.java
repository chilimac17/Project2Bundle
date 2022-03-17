package GraphFunction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class smoother {
    //takes in csv, loop through and replace y values 
    private FileWriter fileWriter;
    private BufferedWriter bufferWriter;
	File inputFile = new File("Salter.csv");
	private Scanner csvReader;
    public smoother(){
        try {
			//.csv
			fileWriter = new FileWriter("Smoother.csv");
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.toString());
		}
    }
    public void createSmoothData(int window){
        bufferWriter = new BufferedWriter(fileWriter);
        ArrayList<Double> xValList = new ArrayList<>(); 
        ArrayList<Double> yValList = new ArrayList<>(); 
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
				    xValList.add(x);
                    yValList.add(y);
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
}
