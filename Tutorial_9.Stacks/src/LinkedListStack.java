/*Implementation of the stack data structure using linked lists 
 *@author Er Lin   
 */
public class LinkedListStack<E> implements Stack<E>{
	
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
	
	private int size; //size of the stack 
	private Node<E> top; //reference to top of stack
	
	//Stack constructor
	public LinkedListStack(){
		top = null; 
		size = 0;
	}
	//Returns number of elements in stack
	public int size() {
		return size;
	}
	//Checks if stack is empty
	public boolean isEmpty() {
		return size == 0;
	}
	//Adds element to the top of the stack
	public void push(E element) {
		Node<E> newNode = new Node<E>(element, top);
		top = newNode;
		size++;
		
	}
	//Removes element from top of the stack
	public E pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return null;
		}
		else {
			E element = top.getData();
			top = top.getNext();
			size--;
			return element;
		}
	}
	//Returns element at the top of the stack
	public E top() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return null;
		}
		return top.getData();
	}
	//Outputs string representation of the stack
	public String toString() {
		
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return null;
		}
		else {
			Node<E> curr = top;
			String output = "Size = " + size() + "\n";
			for(int i = 0; i < size(); i++) {
				output += ">" + curr.getData() + " ";
				curr = curr.getNext();
			}
			return output;
		}
	}
	
	public static void testLinkedListStack() {
		 LinkedListStack<Integer> s = new LinkedListStack<Integer>();
		 
		 s.push(10);
		 s.push(5);
		 System.out.println(s.size() + " = 2"); // contents: (10, 5) outputs 2
		 System.out.println(s.pop() + " = 5"); // contents: (10) outputs 5
		 System.out.println(s.isEmpty() + " = false"); // contents: (10) outputs false
		 System.out.println(s.pop() + " = 10"); // contents: () outputs 10
		 System.out.println(s.isEmpty() + " = true"); // contents: () outputs true
		 System.out.println(s.toString());

		 
		 s.push(7); // contents: (7)
		 s.push(9); // contents: (7, 9)
		 System.out.println(s.top() + " = 9"); // contents: (7, 9) outputs 9
		 s.push(4); // contents: (7, 9, 4)
		 System.out.println(s.size() + " = 3"); // contents: (7, 9, 4) outputs 3
		 System.out.println(s.pop() + " = 4"); // contents: (7, 9) outputs 4
		 s.push(6); // contents: (7, 9, 6)
		 s.push(8); // contents: (7, 9, 6, 8)
		 System.out.println(s.pop() + " = 8"); // contents: (7, 9, 6) outputs 8
		 
		 System.out.println(s.toString());
		}
		
		public static void main(String [] args) {
			
			testLinkedListStack();
		}
}
