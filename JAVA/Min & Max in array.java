//Link:-leetcode.com/problems/maximum-subarray/

import java.util.Arrays;

class Pair 
{                                      // For returning multiple values , a structure is required
	public int min;
	public int max;
}

class Main 
{
	static Pair getMinMax(int arr[]) 
	{
		Pair minmax = new Pair();
		Arrays.sort(arr);             // Uses improved version of Quicksort - Tim sort ( first divide array into runs and sort by insertion sort, then merge sort on runs)
		minmax.min = arr[0];
		minmax.max = arr[arr.length - 1];
		return minmax;
	}
	
	public static void main(String[] args) 
	{
		int arr[] = { 1000, 11, 445, 1, 330, 3000 };
		Pair minmax = getMinMax(arr);
		System.out.println("Minimum element is " + minmax.min);
		System.out.println("Maximum element is " + minmax.max);
	}
}
