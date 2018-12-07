import java.util.LinkedList;
import java.util.Random;

public class PriorityQueue<K extends Comparable<K>, V> implements PQueue<K, V>{

	//myEntry Class
	private static class MyEntry<K extends Comparable<K>, V> implements Entry<K, V>{
		private K k;
		private V v; 
		//constructor
		public MyEntry(K key, V val) {
			k = key;
			v = val;
		}
		//returns the key
		public K getKey() {
			return k;
		}
		//returns the value 
		public V getValue() {
			return v;
		}
		//Compares the 2 keys
		@Override
		public int compareTo(Entry<K, V> o) {
			return this.k.compareTo(o.getKey());
		}
	}
	
	private LinkedList<MyEntry<K, V>> pq;
	private int size;
	
	//PriorityQueue constructor
	public PriorityQueue() {
		pq = new LinkedList<MyEntry<K,V>>();
	}
	//Returns the size of the queue
	public int size() {
		return size;
	}
	//checks if the queue is empty
	public boolean isEmpty() {
		return size == 0;
	}
	//Returns an entry with minimum key
	public Entry<K, V> min() {
		if(pq.isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		else
			return pq.getFirst();
	}
	//inserts a key-value pair
	public Entry<K, V> insert(K key, V val) throws IllegalArgumentException {
		MyEntry<K, V> newEntry = new MyEntry<K,V>(key, val);
		if(pq.isEmpty()) {
			pq.addFirst(newEntry);
		}
		else if(newEntry.compareTo(pq.getLast()) > 0) {
			pq.addLast(newEntry);
		}
		else {
			int i = 0;
			while(newEntry.compareTo(pq.get(i)) > 0) {
				i++;
			}
			pq.add(i, newEntry);
		}
		size++;
		return newEntry;
	}
	//removes an entry with minimum key
	public Entry<K, V> removeMin() {
		if(pq.isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		else {
			size--;
			return pq.removeFirst();
		}
	}
	//Outputs string representation of the queue
	public String toString() {
		String output = new String();
		if(isEmpty())
			output = "Queue is empty!";
		else {
			output = "Size = " + size() + "\n";
			for(int i = 0; i < size(); i++){
				Entry<K, V> a = pq.get(i);
				output += "(" + a.getKey() + ", " + a.getValue() + ")  ";
			}
		}
		return output;
	}
	//method to test priority queue methods
	public static void testPriorityQueue(){
		Random rand = new Random();
		PriorityQueue<Integer, Integer> q = new PriorityQueue<Integer, Integer>();
		System.out.println("Before anything is inserted\n" + q);
		for(int i = 0; i < 10; i++) {
			q.insert(rand.nextInt(5), rand.nextInt(10));
		}
		System.out.println("After random numbers being inserted\n" + q);
		q.removeMin();
		System.out.println("After removing min\n" + q);
		q.insert(4, 7);
		System.out.println("After inserting (4,7)\n" + q);

	}
	//main
	public static void main(String [] args) {
		testPriorityQueue();
	}
}