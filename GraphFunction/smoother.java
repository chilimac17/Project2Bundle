package GraphFunction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class smoother {
	private FileWriter fileWriter;
    private BufferedWriter bufferWriter;
	File inputFile = new File("Salter.csv");
	private Scanner csvReader;
	//contructor
    public smoother(){

        try {
			//.csv
			fileWriter = new FileWriter("Smoother.csv");
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.toString());
		}
    }
	//methods
    public void createSmoothData(){
		//add window = 2
		bufferWriter = new BufferedWriter(fileWriter);
        ArrayList<Double> xValList = new ArrayList<>(); 
        ArrayList<Double> yValList = new ArrayList<>(); 

		//reading csvfile and filling x and y values in the lists created above
		xValList = csvToArrayList(1);
		yValList = csvToArrayList(2);

		printArrayList(xValList);
		//printArrayList(yValList);

    }
	public ArrayList<Double> csvToArrayList(int num){
		
		ArrayList<Double> filledList = new ArrayList<>();
		
		if(num == 1){
			try{
				csvReader = new Scanner(inputFile);
				String line1 = null;
				while((line1 = csvReader.nextLine()) != null){	
					try {
						String line = csvReader.next();
						int comma = line.indexOf(",");
						
							double x = Double.valueOf(line.substring(0,comma));
							filledList.add(x);	
						
					} catch (Exception e) {
							System.out.println("ERROR OCCURED: " + e.toString() + " 1");
						}
					
				}
			}catch (Exception e) {
				System.out.println("ERROR OCCURED: " + e.toString() + " 2");
			}
			
		}else if(num ==2){
			while(csvReader.hasNextLine()){	
				try {
					String line = csvReader.next();
					int comma = line.indexOf(",");
					
						double y = Double.valueOf(line.substring(comma+1));
						filledList.add(y);	
					
				} catch (Exception e) {
						System.out.println("ERROR OCCURED: " + e.toString() + " 3");
					}
				
			}
		}

		return filledList;
	}
	public void printArrayList(ArrayList<Double> list){
        for(int i =0; i < list.size(); i++){
            if(i == list.size()-1){
                System.out.print(list.get(i));
            }else{
            System.out.print(list.get(i) + ", \n");
            }
        }
    }
}

/**
	 * 
		//creating variables
        bufferWriter = new BufferedWriter(fileWriter);
        ArrayList<Double> xValList = new ArrayList<>(); 
        ArrayList<Double> yValList = new ArrayList<>(); 
		int count = 0;
		double yVal;
		double temp = 0;
		double temp2 = 0;
		int diff = 0;
		//create top of csv
		try {
		csvReader = new Scanner(inputFile);
		bufferWriter.write("X " + "," + " Y \n");
		} catch (Exception e) {
			System.out.println("ERROR OCCURED: " + e.toString() + "0");
		}
		//go through csv and add vals to arraylists
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
			} catch (Exception e) {
				    System.out.println("ERROR OCCURED: " + e.toString() + " 4319");
			    }
			count++;
		}
		//smooth out data 
		for(int i = 0; i < xValList.size(); i++){
			yVal = yValList.get(i);
			int check = 0;
			for(int j =0; j < window; j++){
				double val = yValList.get(i+j);
				temp += val;
			}
			//fix
			if(i - window < 0){
				diff = Math.abs(i-window);
				check = 1;
				for(int k=i-1; k > diff; i--){
					double prev = yValList.get(k-diff);
					temp2 += prev;
				}
			}else{
				for(int m = i-1; m > window; m--){
					double prev = yValList.get(m);
					temp2 += prev;
				}
			}
			//fix
			double newVal = temp + temp2 + yValList.get(i);
			if(check == 1){
				int divide = window + diff + 1;
				newVal = newVal/divide;
			}else{
				newVal = newVal/(window + window + 1);
			}
			yValList.set(i, newVal);
		}

		for(int i = 0; i < xValList.size(); i++){
			double n1 = xValList.get(i);
			double n2 = yValList.get(i);
			try {
				bufferWriter.write( n1 + "," + n2 + "\n");
			} catch (IOException e) {
				System.out.println("ERROR OCCURED: " + e.toString() + "2");
				e.printStackTrace();
			}
		}
		try {
			bufferWriter.close();
			} catch (IOException e) {
				
			e.printStackTrace();
			}
	 */