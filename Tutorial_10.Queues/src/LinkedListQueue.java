/* Implementation of a queue using linked lists  
 * @author Er Lin
 */
public class LinkedListQueue<E> implements Queue<E>
{
	//Node of the singly linked list which stores:
	private static class Node<E> {

		private E data; //reference to its data
		private Node<E> next; //reference to following node

		//Node Constructor
		public Node(E e, Node<E> n) {
			setData(e); 
			setNext(n);
		}
		//Accessor that returns data in node
		public E getData() {
			return this.data;
		}		
		//Mutator that sets the data 
		public void setData(E e) {
			this.data = e;
		}
		//returns the node that follows or null if no such node
		public Node<E> getNext() 
		{
			return next;
		}
		//set node's next reference to point to new Node n
		public void setNext(Node<E> n) 
		{
			next = n;
		}
	} 
	
	private Node<E> front, end;
	private int size;

	//LinkedListQueue constructor
	public LinkedListQueue(){
		end = new Node<E>(null, null);
		front = end;
		size = 0;
	}
	//Returns number of elements in queque
	public int size() {
		return size;
	}
	//Checks if the queue is empty
	public boolean isEmpty() {
		return size == 0;
	}
	//Inserts element at end of the queue
	public void enqueue(E element) {
		Node<E> newNode = new Node<E>(element, null);
		if(size == 0)
			front = newNode;
		else 
			end.setNext(newNode);
		end = newNode;
		size++;
	}
	//Removes element from the front of the queue
	public E dequeue() {
		if(isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		else {
			E element = front.getData();
			front = front.getNext();
			size--;
			return element;
		}
	}
	//Returns element at front of the queue
	public E first() {
		return front.getData();
	}
	//function to test ArrayQueue methods
	public static void testLinkedListQueue() {
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
		System.out.println("\n" + q); // q:(2, 3, 4, 5, 6, 7, 8, 9, -1)
	}
	//main
	public static void main(String [] args) {
		testLinkedListQueue();
	}
}
