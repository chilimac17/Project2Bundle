package GraphFunction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class plotter {
    //pick formula/function write a program thta puts x and y values in csv file

    /*
		global variables
	*/
	private FileWriter fileWriter;
	private BufferedWriter bufferWriter;
	
	/*
	this constructor will use filewriter to create a .CSV file 
	*/
	public plotter() {
		try {
			//.csv
			fileWriter = new FileWriter("Plotter.csv");
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.toString());
		}
	}
	
	/*
		this method will create the data we will use to create another histogram and will be stored in a .csv file
		one column will be X which will be from 0-1000
		the next column will be Y which will be the value of the function:
        y = 2x^2+5
	*/
	public void createData() {
		bufferWriter = new BufferedWriter(fileWriter);
		
		try {
		bufferWriter.write("X " + "," + " Y \n");
		} catch (Exception e) {
			System.out.println("ERROR OCCURED: " + e.toString());
		}
		for(int i = 0; i <= 1000; i++ ) {
			try {
				int idNum = i;
				double funcNum = Math.pow(i, 2) + 5;
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
}
