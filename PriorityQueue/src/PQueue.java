/* Interface for priority queue including main methods
 * @author Er lin
 */
public interface PQueue<K, V> 
{
	int size(); //returns number of elements in queue
	boolean isEmpty(); //checks if the queue is empty

	//Inserts a key-value pair and returns the entry created
	Entry<K, V> insert(K key, V val) throws IllegalArgumentException;
	
	//Returns an entry with minimal key
	Entry<K, V> min();

	//Removes and returns an entry with minimal key
	Entry<K, V> removeMin();
}
