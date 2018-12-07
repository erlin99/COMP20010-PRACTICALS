/* Program that counts the number of collisions using different HashCodes
 * @author Er Lin 
 */
import java.io.*;
import java.util.*;

public class ColissionCounter 
{
	//old java hashcode function for strings 
	public static int hashCode(String w) {
		int result = 0;
		int skip = Math.max(1, w.length() / 8);
		for (int i = 0; i < w.length(); i += skip) {
			result = (result * 37) + w.charAt(i);
		}
		return result;
	}
	//polynomial hash code (implementing horner's method)
	public static int polyHashCode(String w, int a) {
		int result = 0;
		for(int i = w.length()-1; i >= 0; i--) {
			result = w.charAt(i) + (a * result);
		}
		
		return result;
	}
	//7-bit cyclic shift hash code
	public static int cyclicHashCode(String w) {
		int result = 0;
	    for (int i = 0; i < w.length(); i++) {
	      // 5-bit cyclic shift of the running sum:
	      result = (result << 7) | (result >>> 25);
	      result += (int) w.charAt(i);   // add in next character
	    }
	    return result;
	}
	//main
	public static void main(String [] args) 
	{
		File file = new File("words.txt");//initialize file
		try {
			LinkedList<Integer> collisions = new LinkedList<Integer>();//list to hold collisions
			HashMap<Integer, String> map = new HashMap<Integer, String>();//map
			
			Scanner scan = new Scanner(file); //initialize scanner
			
			while(scan.hasNext()) {
				String word = scan.next(); //holds current word
				int n = cyclicHashCode(word);//get hash value 
				
				//if the word is already in the map then we have a collision
				if(map.containsKey(n)) {
					//add collision to the list if it is a new one
					if(collisions.indexOf(n) < 0){
						collisions.add(n);
					}
				}
				//if the word is not in the map, enter it
				else {
					map.put(n, word);
				}
			}
			scan.close();
			
			System.out.println("Number of collisions: " + collisions.size());
			
		} catch (FileNotFoundException e) { //if the file is not found
			System.out.println("File not found!");
		}
	}
}
