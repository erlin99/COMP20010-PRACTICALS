/* Student Class
 * @author Er Lin
 */
public class Student implements Comparable<Student>
{
	private String name;
	private int age;
	private double gpa;
	
	//Constructor
	public Student(String n, int a, double d) {
		setName(n);
		setAge(a);
		setGPA(d);
	}
	//Returns the name of student
	public String getName() {
		return this.name;
	}
	//Returns age of the student
	public int getAge() {
		return this.age;
	}
	//Returns gpa of the student
	public double getGPA() {
		return this.gpa;
	}
	//Sets the name to given value
	public void setName(String name) {
		this.name = name;
	}
	//Sets the age to the given value
	public void setAge(int age) {
		this.age = age;
	}
	//Sets the gpa to the given value
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	@Override
	public int compareTo(Student o) {
		if(this.gpa < o.getGPA())
			return - 1;
		else if(this.gpa > o.getGPA())
			return 1;
		else 
			return 0;	
	}
	//Returns string representation of the data
	public String toString() {
		String output = String.format("%20s%10d%10.2f\n", name, age, gpa);
		return output;
	}
}
