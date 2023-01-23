package projectbundle2.GraphFunction;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class salter {
	/**
	 * Global Variables
	 * **File Path: ~/Code/GitHub/Project2Bundle/Plotter.csv**
	 */
    private FileWriter fileWriter;
    private BufferedWriter bufferWriter;
	File inputFile = new File("Plotter.csv");
	private Scanner csvReader;
	private ArrayList<Double> xValList = new ArrayList<>(); 
    private ArrayList<Double> yValList = new ArrayList<>();
    /**
	 * This constructor will use filewriter to create a .CSV file 
	 */
    public salter(){
        try {
			fileWriter = new FileWriter("Salter.csv");
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.toString());
		}
    }
	/**
	 * This method will read the Plotter.csv file and save the values to two arrayLists. After it will call a method to salt the y Values and
	 * put it in a new list. After it will write to the csv files.  
	 */
    public void createSaltData() {
		bufferWriter = new BufferedWriter(fileWriter);
		ArrayList<Double> newYVal = new ArrayList<>();
		csvToArrayList(xValList,yValList);
		newYVal = saltData(yValList);

		try {
			csvReader = new Scanner(inputFile);
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
	 * This method takes in a ArrayList as input displayed as y values and will salt the data. Meaning it will add or subtract a random number from 1-100000. 
	 * @param yList
	 * @return ArrayList<Double> newList
	 */
    public ArrayList<Double> saltData(ArrayList<Double> yList){
        Random rng = new Random();
		ArrayList<Double> newList = new ArrayList<>();
		for(int i = 0; i < yList.size(); i++){
			double y = yList.get(i);
			int addOrSub = rng.nextInt(100000) + 1;
        	int decision = rng.nextInt(2);
        	if(decision == 0){
           	 y = y + addOrSub;
        	}else{
           	 y = y - addOrSub;
       		}
			newList.add(y);
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
