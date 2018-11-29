/* @author Er Lin */

import java.util.Random;

public class Point2D 
{
	private double x;
	private double y;
	
	//Point2D constructor 
	public Point2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	//accessor method that gets value of x
	public double x()
	{
		return this.x;
	}
	
	//accessor method that gets value of y 
	public double y()
	{
		return this.y;
	}
	
	//method that calculates the distance to the given point 
	public double distanceTO(Point2D point)
	{
		double x2 = point.x();
		double y2 = point.y();
		
		double distance = Math.sqrt(Math.pow(this.x - x2, 2) + Math.pow(this.y - y2, 2));
		
		return distance;
	}
	
	//outputs the x and y values of a point
	public String toString()
	{
		return "x = " + this.x + "\ty = " + this.y; 
	}
	

	public static void main(String[] args) 
	{
		Random rand = new Random();//initialize random 
		final int SIZE = 10000; //amount of points 
		double distances = 0;
		int count = 0;
		
		//create array of Point2D objects
		Point2D[] array = new Point2D[SIZE];
		
		//fill the array with randomly generated values
		for(int i = 0; i < SIZE; i++)
		{
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			array[i] = new Point2D(x, y);
		}
		
		//calculate the distances of pair of points 
		for(int i = 0; i < SIZE; i += 2)
		{
			distances += array[i].distanceTO(array[i+1]);
			count++;
		}
		
		//calculate the average
		double average = distances/count;
		
		System.out.println("Average out of " + SIZE + " is " + average);
	}
}
