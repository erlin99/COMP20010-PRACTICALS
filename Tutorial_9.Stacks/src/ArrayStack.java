/*Implementation of the stack data structure using arrays
 * @author Er Lin
 */
public class ArrayStack<E> implements Stack<E> {
	
	private int capacity;
	private static final int CAPACITY = 500;
	private E[] stack;
	private int t = -1;
	
	//Stack default constructor
	@SuppressWarnings("unchecked")
	public ArrayStack(){
		stack = (E[]) new Object[CAPACITY];
		capacity = CAPACITY;
	}
	//Stack constructor
	@SuppressWarnings("unchecked")
	public ArrayStack(int c) {
		capacity = c;
		stack = (E[]) new Object[capacity];
	}
	//Returns number of elements in stack
	public int size() {
		return t+1;
	}
	//Checks if stack is empty
	public boolean isEmpty() {
		return t<0;
	}
	//Adds element to the top of the stack
	public void push(E element) {
		if(size() == capacity)
			System.out.println("Stack is full!");
		else {
			stack[t+1] = element;
			t++;
		}
	}
	//Removes element from top of the stack
	public E pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return null;
		}
		else {
			E element = stack[t];
			stack[t] = null;
			t--;
			return element;
		}
	}
	//Returns element at the top of the stack
	public E top() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return null;
		}
		return stack[t];
	}
	//Outputs string representation of the stack
	public String toString() {
		String output = "Size = " + size() + "\n";
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return null;
		}
		else {
			for(int i = 0; i < size(); i++) {
				output += ">" + stack[i] + " ";
			}
			return output;
		}
	}
	
	public static void testArrayStack() {
	 ArrayStack<Integer> s = new ArrayStack<Integer>();
	 
	 s.push(6);
	 s.push(3);
	 System.out.println(s.size() + " = 2"); // contents: (6, 3) outputs 2
	 System.out.println(s.pop() + " = 3"); // contents: (6) outputs 3
	 System.out.println(s.isEmpty() + " = false"); // contents: (6) outputs false
	 System.out.println(s.pop() + " = 5"); // contents: () outputs 6
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
		
		testArrayStack();
	}
}
















