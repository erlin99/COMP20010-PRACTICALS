/*Implementation of a queue using arrays
 * @author Er Lin 
 */
public class ArrayQueue<E> implements Queue<E>
{
	private int capacity;
	private static final int CAPACITY = 500;
	private E[] q;
	private int front, end, size;
	
	//Queue default constructor
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		q = (E[]) new Object[CAPACITY];
		capacity = CAPACITY;
		size = 0;
		front = end = -1;
	}
	//Queue constructor 
	@SuppressWarnings("unchecked")
	public ArrayQueue(int c) {
		int capacity = c;
		q = (E[]) new Object[capacity];
		size = 0;
		front = end = -1;
	}
	//Returns number of elements 
	public int size() {
		return size;
	}
	//Checks if the list is empty
	public boolean isEmpty() {
		return front<0;
	}
	//Inserts element at end of queue
	public void enqueue(E element) {
		if(isEmpty()) {
			front = end = 0;
			q[end] = element;
		}
		else if(end + 1 >= capacity) {
			System.out.println("Queue is full!");
			return;
		}
		else {
			q[end+1] = element;
			end++;
		}
		size++;
	}
	//Removes element from front of the queue
	public E dequeue() {
		if(isEmpty()) { 
			System.out.println("Queue is empty!");
			return null;
		}
		else if(front == end){
			E element = q[front];
			front = end = -1;
			size--;
			return element;
		}
		else {
			E element = q[front];
			q[front] = null;
			size--;
			front++;
			return element;
		}
	}
	//Returns the first element in the queue
	public E first() {
		return q[front];
	}
	//Ouputs string representation of the queue
	public String toString() {
		if(isEmpty()) { 
			System.out.println("Queue is empty!");
			return null;
		}
		else {
			String output = "Size = " + size() + "\n";
			for(int i = front; i <= end; i++) {
				output += q[i] + " ";	
			}
			return output;
		}
	}
	
	//function to test ArrayQueue methods
	public static void testArrayQueue() {
		ArrayQueue<Integer> q = new ArrayQueue<Integer>(); 
		for(int i = 0; i < 10; ++i) {
			q.enqueue(new Integer(i)); 
		}
		System.out.println(q); // q:(0, 1, 2, 3, 4, 5, 6, 7, 8, 9) 
		q.dequeue();
		System.out.println("\n" + q); // q:(1, 2, 3, 4, 5, 6, 7, 8, 9) 
		q.dequeue();
		System.out.println("\n" + q); // q:(2, 3, 4, 5, 6, 7, 8, 9)
		q.enqueue(-1);
		System.out.println("\n" + q); // q:(2, 3, 4, 5, 6, 7, 8
	}
	//main
	public static void main(String [] args) {
		testArrayQueue();
	}
}
