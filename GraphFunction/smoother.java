package GraphFunction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class smoother {
	private FileWriter fileWriter;
    private BufferedWriter bufferWriter;
	File inputFile = new File("Salter.csv");
	private Scanner csvReader;
	private ArrayList<Double> xValList = new ArrayList<>(); 
    private ArrayList<Double> yValList = new ArrayList<>();
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
    public void createSmoothData(int windowNum){
		//add window = 2
		bufferWriter = new BufferedWriter(fileWriter);
         ArrayList<Double> newYVal = new ArrayList<>();
		//reading csvfile and filling x and y values in the lists created above
		csvToArrayList(xValList,yValList);
		newYVal = smoothData(yValList,windowNum);

		try {
			bufferWriter.write("X " + "," + " Y \n");
			for(int i = 0; i < xValList.size(); i++){
				double n1 = xValList.get(i);
				double n2 = newYVal.get(i);
				bufferWriter.write( n1 + "," + n2 + "\n");
			}
			bufferWriter.close();
			} catch (Exception e) {
				System.out.println("ERROR OCCURED: " + e.toString() + "0");
			}			
    }
	public ArrayList<Double> smoothData(ArrayList<Double> list,int windowNum){
		ArrayList<Double> newList = new ArrayList<>();
		double sum = 0;
		double avg = 0;
		int count = windowNum+1;
		//if size of list is smaller than the window 
		for(int i = 0; i < list.size(); i++){
			int startIndex = i - windowNum;
			int endIndex = i + windowNum;
			if(i == 0 ){
				for(int j = 0; j < windowNum+1; j++){
					sum += list.get(j);
				}
			}else if(startIndex < 0 && i != 0){
				sum += list.get(endIndex);
				count++;
			}else if(endIndex >= list.size()){
				sum -= list.get(startIndex);
				count--;
			}else{
				sum -= list.get(startIndex);
				sum += list.get(endIndex);
			}
			avg = sum / count;
			newList.add(i, avg);
		}
		return newList;
	}
	public void csvToArrayList(ArrayList<Double> xlist,ArrayList<Double> ylist){
			String line = "linezz";
			try{
				csvReader = new Scanner(inputFile);
				String headline = csvReader.nextLine();
				while(csvReader.hasNextLine()){		
					line = csvReader.nextLine();
					String[] row = line.split(",");
					String xVal = row[0];
					String yVal = row[1];
					xlist.add(Double.valueOf(xVal));
					ylist.add(Double.valueOf(yVal));
				}
			}catch(Exception e){
				System.out.println("ERROR1" + e.toString() + "THIS IS LINE: "+ line);
			}
	}
	public void printArrayList(ArrayList<Double> list){
        for(int i =0; i < list.size(); i++){
            if(i == list.size()-1){
                System.out.print(list.get(i));
            }else{
            System.out.print(list.get(i) + "\n");
            }
        }
    }
	public ArrayList<Double> getXArray(){
		return xValList;
	}
	public ArrayList<Double> getYArray(){
		return yValList;
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