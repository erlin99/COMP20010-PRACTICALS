/*Singly Linked List Class
 * Skeleton code provided by Aonghus Lawlor
 * Written by Er Lin 
 */

import java.lang.Exception;
import java.util.Iterator;

//import comp20010.SinglyLinkedList.Node;

public class SinglyLinkedList<E> implements Iterable<E>
{
	//Node of the singly linked list which stores:
	private static class Node<E> {

		private E data; //reference to its data
		private Node<E> next; //reference to following node

		//Node Constructor
		public Node(E e, Node<E> n) 
		{
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

	//instance variables of the SinglyLinkedList
	private Node<E> head; // head node of the list (or null if empty)
//	private Node<E> tail; // last node of the list (or null if empty)
	private int size; // number of nodes in the list

	//Linked list constructor 
	public SinglyLinkedList()
	{
		head = null;
//		tail = null;
		size = 0;
	}
	
	//add node after a given node e
	private void addNodeAfter(Node<E> e, E data)
	{
		Node<E> newNode = new Node<E>(data, e.getNext()); 
		e.setNext(newNode);
		size++;
	}
	
	//get node at given index
//	public Node<E> getNode(int index)
//	{
//		//if list is empty
//		if(isEmpty())
//		{
//			System.out.println("List is empty");
//			return null;
//		}
//		//if the index is greater than the size 
//		else if(index > size)
//		{
//			System.out.println("Out of bounds");
//			return null;
//		}
//		else
//		{
//			Node<E> current = head;
//			for(int i = 0; i < index; i++)
//			{
//				current = current.getNext();
//			}
//			return current;
//		}
//	}
	private Node<E> getNode(int pos) {
		Node<E> curr = head;
		for (int i = 0; i < pos; ++i) {
			curr = curr.next;
		}
		return curr;
	}
	
	//method to get the size of the list
	public int size() 
	{
		return this.size;
	}
	
	//method that checks if list is empty 
	public boolean isEmpty() 
	{
		return size == 0;
	}
	
	//method that gets the first element
	public E first()
	{
		if(isEmpty())
			return null;
		else
			return head.getData();
	}
	
	//method that gets the last element
	public E last()
	{
		if(isEmpty())
			return null;
		else
			return getNode(size-1).getData();
	}
	
	//method that adds new node at beginning of list
	public void addFirst(E data)
	{
		Node<E> newNode = new Node<E>(data, head);
		head = newNode;
		size++;
	}
	
	//method that adds new node at end of list
	public void addLast(E data)
	{
		
		if(isEmpty())
			addFirst(data);
		else
		{
			addNodeAfter(getNode(size-1), data);
		}
	}
	
	//method that adds node at a given index
	public void add(int index, E data)
	{
		if(index == 0)
			addFirst(data);
		else if(index == size)
			addLast(data);
		else
			addNodeAfter(getNode(index-1), data);
	}
	
	//method that removes first node
	public E removeFirst()
	{
		if(isEmpty())
			return null;
		else
		{
			E data = head.getData();
			head = head.getNext();
			size--;
			return data;
		}
	}
	
	//method that removes the last node
	public E removeLast()
	{
		if(isEmpty())
			return null;
		else
		{
			return remove(size);
		}
	}
	
	//method that removes node at a given index
	public E remove(int index)
	{
		Node<E> before = getNode(index-2);
		Node<E> delete = before.getNext();
		before.setNext(delete.getNext());
		size--;
		return delete.getData();
	}
	
	//method that gets data at given index
	public E get(int pos) {
		return getNode(pos).getData();
	}

	//Insert the new element before the key. s: element to insert
	public void insertBefore(E key, E s) 
	{
		if(head == null) {
			return;
		}
		else if(head.getData().equals(key)) {
			addFirst(s);
		}
		else {
			Node<E> prev = null;
			Node<E> cur = head;
			
			while(cur != null && !cur.getData().equals(key))
			{
				prev = cur;
				cur = cur.getNext();
			}
			
			if(cur != null) {
				prev.setNext(new Node<E>(s, cur));
				size++;
			}
			else
				System.out.println("Key not found!");
		}
	}
	


//	//Remove the element key from the list 
//	public void remove(String key) 
//	{
//		if(head == null) {
//			throw new RuntimeException("Cannot remove the element " + key);
//		}
//		else if(head.getData().equals(key)) {
//			removeFirst();
//		}
//		else {
//			Node<E> prev = null;
//			Node<E> cur = head;
//			
//			while(cur != null && !cur.getData().equals(key))
//			{
//				prev = cur;
//				cur = cur.getNext();
//			}
//			
//			prev = cur.getNext();
//		}
//		return;
//	}

	
	//create a duplicate of the original single linked list 
	public Object copy() 
	{
		SinglyLinkedList<E> copy = new SinglyLinkedList<E>();
		Node<E> temp = head;
		while(temp != null)
		{
			copy.addLast(temp.getData());
			temp = temp.getNext();
		}
		return copy;
	}

	public Iterator<E> iterator(){
		return new ListIterator<E>();
	}
	
	private class ListIterator<T> implements Iterator<T> 
	{			
		private Node<T> iterator;
		
		ListIterator(){
			iterator = (Node<T>) head;
		}
		
		public boolean hasNext() {
			return (iterator.getNext() != null);
		}
		
		public T next() {
			T data = iterator.getData();
			iterator = iterator.getNext();
			return data;
		}
	}

	//Produces string representation of the contents of the list.
	public String toString() 
	{
		String output = new String();
		output = "Size = " + size + "\n";
		Node<E> temp = head;

		for(int i = 0; i < size; i++)
		{
			output += temp.getData() + "  ";
			temp = temp.getNext();
		}
		return output;
	}
}

