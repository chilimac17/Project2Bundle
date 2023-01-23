package projectbundle2.GraphFunction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class smoother {
	/**
	 * Global Variables
	 * **File Path: ~/Code/GitHub/Project2Bundle/Salter.csv**
	 */
	private FileWriter fileWriter;
    private BufferedWriter bufferWriter;
	File inputFile = new File("Salter.csv");
	private Scanner csvReader;
	private ArrayList<Double> xValList = new ArrayList<>(); 
    private ArrayList<Double> yValList = new ArrayList<>();
	/**
	 * This constructor will use filewriter to create a .CSV file 
	 */
    public smoother(){
        try {
			fileWriter = new FileWriter("Smoother.csv");
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.toString());
		}
    }
	/**
	 * This method will read the Salter.csv file and save the values to two arrayLists. After it will call a method to smooth the y Values and
	 * put it in a new list. After it will write to the csv files.  
	 * @param windowNum
	 */
    public void createSmoothData(int windowNum){
		bufferWriter = new BufferedWriter(fileWriter);
         ArrayList<Double> newYVal = new ArrayList<>();
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
	/**
	 * This method takes in a ArrayList and a window value. It will run a for loop through the list. It will run various checks adjusting to the proper window size
	 * as the for loop progresses. Once the new y is calculated it will be added to a new list. 
	 * @param list
	 * @param windowNum
	 * @return ArrayList<Double> newList
	 */
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
	/**
	 * This method is used to read the csv file created by plotter and save the x and y values in seperate arrayLists. First it creates a scanner to read the file.
	 * Then it stores every line and splits it up at the ",". Doing this will have the x and y values saved in position 0 and 1 in the temp array called row. Once the values are
	 * obtained then it will add them to the proper lists.
	 * @param xlist
	 * @param ylist
	 */
	public void csvToArrayList(ArrayList<Double> xlist,ArrayList<Double> ylist){
			String line = "";
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
	/**
     * This method was created to print out an array for testing purposes
     * @param list
     */
	public void printArrayList(ArrayList<Double> list){
        for(int i =0; i < list.size(); i++){
            if(i == list.size()-1){
                System.out.print(list.get(i));
            }else{
            System.out.print(list.get(i) + "\n");
            }
        }
    }
	/**
	 * Getter for xValList
	 * @return ArrayList<Double> xValList
	 */
	public ArrayList<Double> getXArray(){
		return xValList;
	}
	/**
	 * Getter for yValList
	 * @return ArrayList<Double> yValList
	 */
	public ArrayList<Double> getYArray(){
		return yValList;
	}
}