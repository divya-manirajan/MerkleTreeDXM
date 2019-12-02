/**
 * This class reads the data from the file and creates data blocks out of the strings
 */

//imorts
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DataReader {
	static DataBlock data = new DataBlock(); //creates new variable to hold DataBlock info
	public static ArrayList <DataBlock> dataBlocks; //creates new variable to hold an arrayList of datablocks
	/**
	 * initializes dataBlocks to empty
	 */
	public DataReader() {
		dataBlocks = new ArrayList<DataBlock>();
	}//end constructor
	
	/**
	 * 
	 * @param f is the file the user enters
	 * @throws FileNotFoundException to account for an invalid file
	 */
	public static void setBlocks(File f) throws FileNotFoundException {
		Scanner fileScan = new Scanner(f);
		while(fileScan.hasNextLine()) {
			String s = fileScan.nextLine();
			data.add(s);
			//dataBlocks.add(data);  -- was supposed to continuously add file info
			//as a data block to use for computing the merkle tree but leads to NullPointerException
		}//end while to continue adding data until the file is completed
	}//end setBlocks
	
	/**
	 * 
	 * @return an arraylist of strings that contain the blocks
	 */
	public static ArrayList <String> getBlocks() {
		return data.getData();
	}//end getBlocks
	
	/**
	 * 
	 * @return an array list of data blocks to use for the merkle tree
	 */
	public static ArrayList <DataBlock> getDataBlocks(){
		return dataBlocks;
	}//end getDataBlocks

	
}//end DataReader
