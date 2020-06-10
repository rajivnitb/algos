package com.algo.dp;

/**
 * https://www.interviewbit.com/problems/stairs/
 * @author RajivDevaraj
 *
 */
public class Steps {

	public Integer countSteps(int count,Integer sum) {
		
		if (sum == 0) {
			return 1;
		}
		
		count=countSteps(count,sum-1);
		if (sum >=2)
		count+=countSteps(count,sum-2);
		
		return count;
		
	}
	
	public static void main(String args[]) {
		System.out.println(new Steps().countSteps(4,4));
	}
}
