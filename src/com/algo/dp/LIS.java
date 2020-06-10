package com.algo.dp;

/**
 * https://www.interviewbit.com/problems/longest-increasing-subsequence/
 * @author RajivDevaraj
 *
 */
public class LIS {

	static int maxCount = Integer.MIN_VALUE;

	public int getMaxCount(int []a) {
		if (a.length == 0) {
			return 0;
		}
			getLIS(a, 0, 0, 0);
			return maxCount + 1;
		
	}
	public int getLIS(int[] a, int index, int shuffleIndex, int count) {
		
		

		if (index >= a.length - 1) {
			return count;
		}

		
		
		for (int i = shuffleIndex; i <= a.length - 1; i++) {

			if (a[i] > a[shuffleIndex]) {
				int j = getLIS(a, i, i, count + 1);
				maxCount = Math.max(maxCount, j);
               
			}

		}

		
		
		if (index <= a.length - 1) {
			getLIS(a, index + 1, index + 1, 0);
		} 

		return count;

	}

	public static void main(String args[]) {
		int[] a = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		//int[] a = { 10, 1, 2, 1, 20 };
		//int []a= {};
		
		System.out.println(new LIS().getMaxCount(a));
		

	}

}
