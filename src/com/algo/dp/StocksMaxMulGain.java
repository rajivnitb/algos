package com.algo.dp;

/**
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
 * @author RajivDevaraj
 *
 */
public class StocksMaxMulGain {

	public int maxGain(int []a,int maxProfit,int buy,int index,boolean flag) {
		if (index > a.length-1) {
			return maxProfit;
		}
		
		if (index == 0 || flag) {
		  buy=a[index];
		  
		}
		
		if (index != 0 && a[index] > buy) {
			maxProfit=maxProfit+a[index]-buy;
			buy=a[index];
			
		}
	
		return Math.max(maxGain(a,maxProfit,buy,index+1,false),maxGain(a,maxProfit,buy,index+1,true));
	}
	
	
	public static void main(String args[]) {
		int []a= {7,2,4,8,7};
		System.out.println(new StocksMaxMulGain().maxGain(a,0,0,0,true));
	}
}
