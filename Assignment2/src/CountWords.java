/* Implementation of HashMaps to count the different words in a file
 * and output the top 10 most frequent words. 
 * @author Er Lin 
 */
import java.io.*;
import java.util.*;

public class CountWords 
{
	public static void main(String [] args)throws FileNotFoundException, IOException
	{

		File file = new File("sample_text.txt"); //initialize file
		try {
			HashMap<String, Integer> map = new HashMap<String, Integer>(); //initialize map
			int count = 0;//count of the words
			Scanner scan = new Scanner(file); //initialize scanner
			scan.useDelimiter("[^a-zA-Z]"); //limit the scanner to just the words

			//while there are still words in the file
			while(scan.hasNext()) {
				String word = scan.next(); //holds current word
				//if the word is already in the map increase the value
				if(map.containsKey(word)) {
					int n = map.get(word)+1;
					map.put(word, n);
				}
				//if the word is not in the map, enter it with value 1
				else {
					map.put(word, 1);
					count++;
				}
			}
			scan.close();//close scanner
			
			//List with all elements of the hash map
			List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
			
			// Sorting the list by value in descending order 
	        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
	            public int compare(Map.Entry<String, Integer> x, Map.Entry<String, Integer> y) 
	            { 
	                return (y.getValue()).compareTo(x.getValue()); 
	            } 
	        }); 
	        
	        System.out.println("Number of words: " + (count-1)); //output number of different words. 
	        System.out.println("Top 10 most frequent words:");
	        //print out top 10 most frequent words
	        int i = 0;
	        for(Map.Entry<String, Integer> temp : list) {
	        	if(i == 0) {
	        		i++;
	        		continue;
	        	}
	        	if(i < 10) {
	        		System.out.println(i + "." + temp.getKey() + "  Count:" + temp.getValue());
	        		i++;
	        	}
	        	else
	        		break;
	        }
	        
		} catch (FileNotFoundException e) //if the file is not found
		{
			System.out.println("File not found!");
		}
	}
}
