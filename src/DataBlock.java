/**
 * This class manages the data blocks
 */
//imports
import java.util.ArrayList;

public class DataBlock {
	public static ArrayList <String> data; //creates arraylist for the data
	public DataBlock() {
		data = new ArrayList<String>();
	}//empty constructor sets data to empty
	/**
	 * 
	 * @param s the value of the string data
	 */
	public DataBlock(String s) {
		data.add(s);
	}//end constructor
	/**
	 * 
	 * @param s the value of the string data to add
	 */
    public void add(String s) {
    	data.add(s);
    }//end add
    
    /**
     * I created this to make sure the setBlocks method in DataReader was working
     * @return an arrayList of all the data 
     */
    public static ArrayList <String> getData() {
    	ArrayList <String> DataBlocks = new ArrayList <String>();
    	for(int i = 0; i<data.size();i++){
    	DataBlocks.add(data.get(i) + "\n");
    	}//end for
    	return DataBlocks;
    }//end getData
}//end DataBlock
