/* Interface for priority queue including main methods
 * @author Er lin
 */
public interface PQueue<E> 
{
	int size(); //returns number of elements in queue
	boolean isEmpty(); //checks if the queue is empty

	//Inserts a key-value pair and returns the entry created
	E insert(E x);
	
	//Returns an entry with minimal key
	E min();

	//Removes and returns an entry with minimal key
	E removeMin();
}
