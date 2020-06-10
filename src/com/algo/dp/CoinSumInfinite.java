package com.algo.dp;

/**
 * https://www.interviewbit.com/problems/coin-sum-infinite/
 * 
 * @author RajivDevaraj
 *
 */

public class CoinSumInfinite {

	public int findCoinSum(int a[], int index, int sum) {
		if (sum == 0)
			return 1;

		if (sum < 0)
			return 0;

		if (index <= 0 && sum >= 1)
			return 0;

		return findCoinSum(a, index - 1, sum) + findCoinSum(a, index, sum - a[index - 1]);
	}

	// this works but also bring duplicate combo count
	/*
	 * public int findCoinsSum(int []a,List <Integer> list,Integer sum) {
	 * 
	 * if (sum == 0) { if (list.isEmpty()) { list.add(1); return list.get(0); }else
	 * { list.add(0,list.get(0)+1);
	 * 
	 * } }
	 * 
	 * 
	 * if (Math.signum(Double.valueOf(sum)) == -1 || sum > 4) { return list.get(0);
	 * }
	 * 
	 * for (int i = 0 ; i <= a.length-1 ; i++) { findCoinsSum(a,list,sum-a[i]); }
	 * 
	 * return list.get(0) ;
	 * 
	 * }
	 */

	public static void main(String args[]) {
		int[] a = { 1, 2, 3 };
		System.out.println(new CoinSumInfinite().findCoinSum(a, a.length, 4));

	}
}
