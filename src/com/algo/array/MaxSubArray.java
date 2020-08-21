package com.algo.array;


/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 * @author RajivDevaraj
 *
 */
public class MaxSubArray {
	
	public int maxSubArray(int []a,int index,int max) {
		if (index >= a.length-1) {
			return max;
		}
		
		int sum=a[index];
		for (int i=index+1;i< a.length;i++) {
			sum=sum+a[i];
			max = Math.max(max,sum);
		}
		
		return Math.max(maxSubArray(a, index+1, max),maxSubArray(a, index+1, max));
	}

	public static void main(String args[]) {
		int [] a= {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(new MaxSubArray().maxSubArray(a, 0, Integer.MIN_VALUE));
	}
}
