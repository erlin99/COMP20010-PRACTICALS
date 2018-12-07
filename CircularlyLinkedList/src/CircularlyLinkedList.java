/*Implementation of a Circular Linked List
 * @author Er Lin 
*/
public class CircularlyLinkedList<E>
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
		public Node<E> getNext() {
			return next;
		}

		//set node's next reference to point to new Node n
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	private int size; //size of the list 
	private Node<E> pointer; //keeps track of a node
	
	//Circular linked list constructor
	public CircularlyLinkedList() {
		size = 0; 
		pointer = null;
	}
	//Returns the size of the list
	public int size() {
		return size;
	}
	//Checks if the list is empty
	public boolean isEmpty() {
		return size == 0;
	}
	//Returns the pointer node
	public Node<E> getPointer(){
		return pointer;
	}
	//Moves the pointer to the next node
	public void moveForward() {
		pointer = pointer.getNext();
	}
	//Adds element after the node pointed by pointer
	public void add(E data) {
		Node<E> newNode = new Node<E>(data, null);
		//if the list is empty
		if(isEmpty()) {
			newNode.setNext(newNode);
			pointer = newNode;
		}
		else {
			newNode.setNext(pointer.getNext());
			pointer.setNext(newNode);
		}
		size++;
	}
	//Removes node after the pointer and returns removed element
	public E remove() {
		E data = pointer.getNext().getData();
		//if there is only one node in the list
		if(size() == 1) {
			pointer = null;
		}
		else {
			pointer.setNext(pointer.getNext().getNext());
		}
		size--;
		return data;
	}
	//String representation of the list
	public String toString() {
		String output = new String();
		if(isEmpty()) {
			output = "List is empty";
		}
		else {
			Node<E> curr = pointer;
			output += "Size = " + size() + "\n";
			for(int i = 0; i  < size(); i++) {
				output += ">" + curr.getData() + "  ";
				curr = curr.getNext();
			}
		}
		return output;
	}
	
	public static void main(String [] args) {
		System.out.println("Testing circular linked lists:");
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list); //it should print [0, 9, 8, 7, 6, 5, 4, 3, 2, 1]
		
		list.remove();
		list.remove();
		
		System.out.println(list); //it should print [0, 7, 6, 5, 4, 3, 2, 1]
		
		list.moveForward();
		System.out.println(list); //it should print [7, 6, 5, 4, 3, 2, 1, 0]
	}
}











