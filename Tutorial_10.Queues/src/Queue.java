/*Interface for queues including the main methods
 * @author Er Lin 
 */
public interface Queue<E> 
{
	int size();//returns the number of elements in the queue
	boolean isEmpty(); //checks if the queue is empty 
	
	void enqueue(E element);//Inserts element at end of queue
	E dequeue();//Removes element at the front of the queue
	E first(); //Returns element at the front of the queue
}
