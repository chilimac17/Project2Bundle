package projectbundle2.GraphFunction;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
public class plotter {
    /**
	 * Global Variables
	 */
	private FileWriter fileWriter;
	private BufferedWriter bufferWriter;
	private ArrayList<Double> xValList = new ArrayList<>(); 
    private ArrayList<Double> yValList = new ArrayList<>();
	/**
	 * This constructor will use filewriter to create a .CSV file 
	 */
	public plotter() {
		try {
			fileWriter = new FileWriter("Plotter.csv");
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.toString());
		}
	}
	/**
	 * This method will create the data we will use to create another histogram and will be stored in a .csv file 
	 * one column will be X which will be from 0-1000 the next column will be Y which will be the value of the function: y = 2x^2+5
	 */
	public void createData() {
		bufferWriter = new BufferedWriter(fileWriter);
		AddValues(xValList, yValList);
		try {
			bufferWriter.write("X " + "," + " Y \n");
			for(int i = 0; i < xValList.size(); i++){
				bufferWriter.write(xValList.get(i) + "," + yValList.get(i) + "\n");
			}	
			bufferWriter.close();
		} catch (Exception e) {
			System.out.println("ERROR OCCURED: " + e.toString());
		}
		
		
	}
	/**
	 * This method is used to add the x and y values to seperate arrayLists to be written in the createData method.
	 * @param xlist
	 * @param ylist
	 */
	public void AddValues(ArrayList<Double> xlist,ArrayList<Double> ylist){
		for(int i = 0; i <= 1000; i++ ) {
			double idNum = i;
			double funcNum = Math.pow(i, 2) + 5;
				xlist.add(idNum);
				ylist.add(funcNum);
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
