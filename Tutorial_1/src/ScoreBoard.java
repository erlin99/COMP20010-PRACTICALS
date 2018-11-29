/* Scoreboard Class
 * Skeleton code provided by: Aonghus Lawlor
 * Written by: Er Lin */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScoreBoard 
{
	private int maxEntries;
	private int numEntries; //number of actual entries
	private GameEntry[] board; //array of game entries (name and scores)

	//ScoreBoard constructor
	public ScoreBoard(int capacity) 
	{
		maxEntries = capacity;
		numEntries = 0; 
		board = new GameEntry[maxEntries];
	}

	//If the number is high enough this method adds the new score to the board
	public void add(GameEntry e) 
	{
		int score = e.getScore();

		if(numEntries < board.length || score > board[maxEntries - 1].getScore())
		{
			if(numEntries < board.length)
				numEntries++;
			
			int i = numEntries - 1;
			
			//move all numbers to the right to free up one space
			while(i > 0 && board[i-1].getScore() < score)
			{
				board[i] = board[i-1];
				i--;
			}
			//insert new score 
			board[i] = e;       
		}
	}

	//Method that removes an existing score from the board
	public GameEntry remove(int i) throws IndexOutOfBoundsException 
	{
		//in case that the index is out of bound 
		if(i < 0 || i >= numEntries)
			throw new IndexOutOfBoundsException("Score index is invalid");
				
		GameEntry temp = board[i];
		numEntries--;
				
		//move all objects to the left 
		for(int j = i; j < numEntries; j++)
		{
			board[j] = board[j+1];
		}
				
		return temp;
	}

	//Outputs the scoreboard
	public String toString() 
	{	
		String s = "Scoreboard (" + numEntries + ")\n";
		for(int i = 0; i < numEntries; i++)
		{
			s += board[i].toString() + "\n";
		}
		return s;
	}

	public static void main(String[] args) 
	{
		// create a new scoreboard
		ScoreBoard scoreboard = new ScoreBoard(10);
		
		File file = new File("scores.txt");
		try {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNext()) 
				{
					String line = scanner.nextLine();
					Scanner lineReader = new Scanner(line).useDelimiter(",\\s?+"); // comma followed by any number of spaces
					// read the name and score
					String name = lineReader.next();
					int score = lineReader.nextInt();
						
					// create the GameEntry object
					GameEntry e = new GameEntry(name, score);
							
					// add to scoreboard
					scoreboard.add(e);
							
					lineReader.close();
				}
				scanner.close();
				System.out.println(scoreboard.toString());
		
			//if file is not found
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found!");
		}
	}
}

