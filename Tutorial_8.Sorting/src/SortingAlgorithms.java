import java.util.Random;

public class SortingAlgorithms<E> 
{
	//print array 
	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
	}
	
	//Implementation of selection sort
	public static void selectionSort(int[] a) {
			
		for(int i = 0; i < a.length-1; i++) {
			int min = i;
			for(int j = i+1; j < a.length; j++) {
				if(a[j] < a[min])
					min = j;
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}
		
	//Implementation of bubble sort
	public static void bubbleSort(int[] a) {
		for(int i = 1; i < a.length; i++) {
			for(int j = 0; j < a.length-1; j++) {
				if(a[j] > a[j+1]) //if the previous element is greater swap them 
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	//Implementation of merge sort
	public static void mergeSort(int[] a, int x, int y) {
		if(x - y <= 1) //if length 0 or 1, it is already sorted. 
			return;
		else {
			int middle = (x-y)/2;
			mergeSort(a, x, middle);
			mergeSort(a, middle, y);
			merge(a, x, middle, y);
		}
	}
	//merge function for mergeSort
	public static void merge(int[] a, int x, int mid, int y) {
		int half1 = mid-x+1;
		int half2 = y-mid;
		//temporary arrays
		int[] X = new int[half1];
		int[] Y = new int[half2];
		
		//copy data into the temporal arrays
		for(int i = 0; i < half1; i++) {
			X[i] = a[x+i];
		}
		for(int i = 0; i < half1; i++) {
			Y[i] = a[mid+1+y];
		}
		
		int i=0, j=0, k=x;
		//initial indexing
		while(i < half1 && j < half2) {
			if(X[i] <= X[i]) {
				a[k] = X[i];
				i++;
			}
			else {
				a[k] = Y[i];
				j++;
			}
			k++;
		}
		//If they are remaining elements in X include them in main array
		while(i < half1) {
			a[k] = X[i];
			i++;
			k++;
		}
		//If they are remaining elements in Y include them in main array
		while(j < half2) {
			a[k] = Y[i];
			j++;
			k++;
		}
	}
	
	public static void main(String [] args) {
		Random rand = new Random();
		final int SIZE = 10;
		int[] array = new int[SIZE];
		
		System.out.println("Array before sorting:");
		//filling array with random numbers
		for(int i = 0; i < SIZE; i++) {
			array[i] = rand.nextInt(10) + 1;
		}
		printArray(array);
		
		System.out.println("\n\nAfter selection sort:");
		selectionSort(array);
		printArray(array);
		
		System.out.println("\nAfter bubble sort:");
		bubbleSort(array);
		printArray(array);
		
		System.out.println("\nAfter bubble sort:");
		mergeSort(array, 0, SIZE);
		printArray(array);
	}
}
