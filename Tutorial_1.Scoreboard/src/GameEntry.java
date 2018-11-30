/* GameEntry Class
 * Skeleton code provided by: Aonghus Lawlor
 * Written by: Er Lin
 */

public class GameEntry 
{
	protected String name; //name of person 
	
	protected int score; //person's score 

	//GameEntry Constructor
	public GameEntry(String name, int score) 
	{
		setName(name);
		setScore(score);
	}

	//Accessor method that gets the name 
	public String getName() 
	{
		return name;
	}

	//Accessor method that gets the score
	public int getScore() 
	{
		return score;
	}

	//Mutator method that sets the name 
	public void setName(String name) {
		this.name = name;
	}

	//Mutator method that sets the score
	public void setScore(int score) 
	{
		this.score = score;
	}

	//Accessor method that returns the string representation of the data
	public String toString() 
	{
		return String.format("%10s %10s", name, score);
	}
}