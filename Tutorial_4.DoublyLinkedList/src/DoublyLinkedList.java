/* Doubly Linked List Class
 * @author Er Lin 
*/

public class DoublyLinkedList<E> 
{
	private static class Node<E> 
	{
		private E data; //data stored in node
		private Node<E> prev, next;//pointers to previous and next nodes
		
		//Node constructor
		public Node(E data, Node<E> prev, Node<E> next)
		{
			setData(data);
			setPrev(prev);
			setNext(next);
		}
		//Returns the data stored
		public E getData() {
			return this.data;
		}
		//Returns the previous node
		public Node<E> getPrev(){
			return this.prev;
		}
		//Returns the next node
		public Node<E> getNext(){
			return this.next;
		}
		//Sets the data in the node
		public void setData(E data) {
			this.data = data;
		}
		//Sets the previous node
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		//Sets the next node
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	private int size; //size of the linked list
	private Node<E> header, trailer;//first and last dummy nodes
	
	//Doubly Linked List constructor
	public DoublyLinkedList() {
		size = 0;
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer);
	}
	//Returns the size of list 
	public int size() {
		return size;
	}
	//Check if list is empty
	public boolean isEmpty() {
		return size == 0;
	}
	//Returns first node
	public Node<E> first() {
		if(isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		else {
			return header.getNext();
		}
	}
	//Returns last node
	public Node<E> last(){
		if(isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		else {
			return trailer.getPrev();		
		}
	}
	//Returns node at given index
	public Node<E> getNode(int index) throws IndexOutOfBoundsException {
		if(isEmpty()) //if the list is empty 
		{
			System.out.println("List is empty");
			return null;
		}
		else if(index == 1) //if want to get first element
			return first();
		else if(index == size()) //if want to get last element
			return last();
		else if(index > size()/2) //if element is at 2nd half of the list
		{
			Node<E> curr = trailer.getPrev();
			for(int i = 0; i < size()-index; i++) {
				curr = curr.getPrev();
			}
			return curr;
		}
		else //if element is in first half of the list 
		{
			Node<E> curr = header.getNext();
			for(int i = 0; i < index; i++) {
				curr = curr.getNext();
			}
			return curr;
		}
	}
	//Adds element before given node n
	public void addBefore(Node<E> n, E data) {
		Node<E> prev= n.getPrev();
		Node<E> newNode = new Node<E>(data, prev, n);
		prev.setNext(newNode);
		n.setPrev(newNode);
		size++;
	}
	//Adds element after a given node n
	public void addAfter(Node<E> n, E data) {
		Node<E> next = n.getNext();
		Node<E> newNode = new Node<E>(data, n, n.getNext());
		next.setPrev(newNode);
		n.setNext(newNode);
		size++;
	}
	//Adds element at beginning of list
	public void addFirst(E data) {
		addAfter(header, data);
	}
	//Adds element at end of list
	public void addLast(E data) {
		addBefore(trailer, data);
	}
	//Removes first element of the list
	public E removeFirst() {
		if(isEmpty()) //if the list is empty
		{
			System.out.println("List is empty");
			return null;
		}
		else {
			E data = first().getData();
			header.setNext(first().getNext());
			size--;
			return data;
		}
	}
	//Removes last element of the list
	public E removeLast() {
		if(isEmpty()) //if the list is empty
		{
			System.out.println("List is empty");
			return null;
		}
		else {
			E data = last().getData();
			trailer.setPrev(last().getPrev());
			size--;
			return data;
		}
	}
	//Removes the given node n form list
	public E remove(Node<E> n) {
		if(isEmpty()) //if the list is empty
		{
			System.out.println("List is empty");
			return null;
		}
		else if(n == first()) {
			return removeFirst();
		}
		else if(n == last()) {
			return removeLast();
		}
		else {
			E data = n.getData();
			Node<E> prev = n.getPrev();
			Node<E> next = n.getNext();
			prev.setNext(next);
			next.setPrev(prev);
			size--;
			return data;
		}
	}
	//String representation of the list
	public String toString() {
		String output = new String();
		Node<E> curr = header.getNext();
		output += "size = " + size() + "\n";
		for(int i = 0; i < size(); i++) {
			output +=  ">"+ curr.getData() + "   ";
			curr = curr.getNext();
		}
		return output;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
		ll.addFirst(0);
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addLast(-1);
		System.out.println(ll);
		
		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();
		System.out.println(ll); 
		
	}
}

