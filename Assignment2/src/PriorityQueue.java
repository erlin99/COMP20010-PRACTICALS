/* Implementation of the Priority queue for students graduation
 * @author Er Lin 
 */
import java.util.LinkedList;

public class PriorityQueue<E extends Comparable<E>> implements PQueue<E>{
	
	private LinkedList<E> pq;
	private int size;
	
	//PriorityQueue constructor
	public PriorityQueue() {
		pq = new LinkedList<E>();
		size = 0;
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
	public E min() {
		if(pq.isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		else
			return pq.getFirst();
	}
	//inserts a key-value pair
	public E insert(E student) throws IllegalArgumentException {
		//if queue is empty
		if(pq.isEmpty()) {
			pq.addFirst(student);
		}
		//else if it should be at the end
		else if(student.compareTo(pq.getLast()) < 0) {
			pq.addLast(student);
		}
		else {
			int i = 0;
			while(student.compareTo(pq.get(i)) < 0) {
				i++;
			}
			pq.add(i, student);
		}
		size++;
		return student;
	}
	//removes an entry with minimum key
	public E removeMin() {
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
			output = String.format("%20s%10s%10s", "Name", "Age", "GPA\n");
			for(int i = 0; i < size(); i++){
				E a = pq.get(i);
				output += a;
			}
		}
		return output;
	}

	//main
	public static void main(String [] args) {
		PriorityQueue<Student> q = new PriorityQueue<Student>();

		q.insert(new Student("Natalie Ware", 21, 4.0));
		q.insert(new Student("Mira Weiss", 19, 3.5));
		q.insert(new Student("Emilie Gibbs", 20, 3.2));
		q.insert(new Student("Lisa Boone", 22, 4.7));
		q.insert(new Student("Karsyn Terry", 20, 4.8));
		q.insert(new Student("Jeremy Schwartz", 18, 4.6));
		q.insert(new Student("Aleah Gaines", 19, 4.1));
		q.insert(new Student("Arianna Reeves", 20, 3.9));
		q.insert(new Student("Walker Holloway", 22, 3.8));
		q.insert(new Student("Adelyn Walter", 24, 4.95));
		q.insert(new Student("Damion Sanders", 25, 3.2));
		q.insert(new Student("Aimee Quinn", 21, 2.7));
		System.out.println(q);
	}
}