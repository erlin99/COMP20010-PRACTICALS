/*Interface for a stack including the main methods
 * @author Er Lin 
 */

public interface Stack<E> 
{
	int size(); //returns number of elements in stack 
	boolean isEmpty(); //checks if the stack is empty
	
	E top(); //Returns element at top of the stack 
	
	void push(E element); //adds element at top of the stack
	E pop(); //Removes the top element of the stack
}
