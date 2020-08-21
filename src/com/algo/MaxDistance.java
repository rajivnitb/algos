package com.algo.array;

/**
 * https://www.interviewbit.com/problems/max-distance/
 * 
 * @author RajivDevaraj
 *
 */
public class MaxDistance {

	public int maximumGap(int a[], int index, int max) {
		if (index >= a.length - 1) {
			return max;
		}

		for (int i = index + 1; i < a.length; i++) {
			if (a[i] - a[index] > 0) {
				max = Math.max(max, i - index);
			}

		}

		return Math.max(maximumGap(a, index + 1, max), maximumGap(a, index + 2, max));
	}

	public static void main(String args[]) {
		int[] a = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };

		System.out.println(new MaxDistance().maximumGap(a, 0, Integer.MIN_VALUE));
	}

}
