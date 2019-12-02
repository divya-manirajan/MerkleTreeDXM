/**
 * This class creates the merkle tree and is used to hash the data
 */

//imports
import TreePackage.*;
import StackAndQueuePackage.*;
import java.security.*;
import java.util.ArrayList;

public class MerkleTree{
	//instance variables:
	public static String hash; //variable to hold the hash
	public static String root;//variable for the hash of the root subtree
	public static String left; //Variable for the hash of the left subtree
	public static String right; //Variable for the hash of the right subtree
	
	public static ArrayList <String> allHashes; //array list to hold all hashes made
	
	ArrayBinaryTree rootTree = new ArrayBinaryTree(); //creates a basic tree with one root
	ArrayBinaryTree leftTree = new ArrayBinaryTree(); //creates a subtree for the left side
	ArrayBinaryTree rightTree = new ArrayBinaryTree(); //creates a subtree for the right side
	ArrayBinaryTree Full = new ArrayBinaryTree(); //creates a full tree using the above subtrees

	public MerkleTree(ArrayList <DataBlock> d) throws NoSuchAlgorithmException{
		for(int i = 0; i<d.size(); i+=2) {
			left = hash(d.get(i).toString());
			right = hash(d.get(i+1).toString());
			root = hash(left+right);
			
			rootTree.setTree(root);
			leftTree.setTree(left);
			rightTree.setTree(right);
			
			Full.setTree(rootTree, leftTree, rightTree);
		}//for loops counts by 2 so no leaves are repeatedly hashed
	}//end constructor
	
	/**
	 * 
	 * @param s is the string needing to be hashed
	 * @return a string that contains the hash value
	 * @throws NoSuchAlgorithmException in case hash fails to execute
	 */
	public static String hash(String s) throws NoSuchAlgorithmException {
		try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(s.getBytes());
		byte[] bytes = md.digest();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		hash = sb.toString();
		//allHashes.add(hash);
		
		}//end try to create hash
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}//end catch
		return hash;
	}//end hash
	
	/**
	 * 
	 * @return an array list of all possible hashes made
	 */
	public static ArrayList <String> printHashes(){
		return allHashes;
	}//end printHashes
	
}//end MerkleTree


