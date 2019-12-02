/**
 * This is the main application and it prints out hashes to the screen.
 * 
 * @author Divya Manirajan
 * @version December 2, 2019
 * Fall/2019
 */
//imports
import java.io.*;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //creates scanner to read the file name
		System.out.print("Enter the name of the file to hash: ");
		String fileName = scan.next();
		try {
			File file = new File(fileName);
			DataReader.setBlocks(file); //sets each block of data to correspond to the file
			Scanner fileScan = new Scanner(file); //creates scanner for the file itself
			while(fileScan.hasNext()) {
				String hash = MerkleTree.hash(fileScan.nextLine());
				System.out.println(hash);
			}//while loops print out hashes to screen for each data block
			

			//MerkleTree tree = new MerkleTree(DataReader.getDataBlocks());
			//tree.printHashes();

		}//end try
		catch(Exception e) {
			e.printStackTrace();
		}//end catch
		
	
	}//end main

}//end Application
