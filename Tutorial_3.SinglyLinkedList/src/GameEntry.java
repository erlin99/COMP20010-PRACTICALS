/* GameEntry class
 * Skeleton code provided by Aonghus Lawlor
 * Written by Er Lin
 */
public class GameEntry
{
	protected String name; //name of the player
	protected int score; //score scored by the player

	//GameEntry constructor
	public GameEntry(String name, int score) {
		this.name = name;
		this.score = score;
	}
	//Returns the name of the player
	public String getName() {
		return this.name;
	}
	//Returns the score by the player
	public int getScore() {
		return this.score;
	}
	//Sets the name of the player 
	public void setName(String name) {
		this.name = name;
	}
	//Sets the score scored by player
	public void setScore(int score) {
		this.score = score; 
	}
	//Returns a string representation of GameEntry
	public String toString() 
	{
		return String.format("%10s %10s", name, score);
	}
}