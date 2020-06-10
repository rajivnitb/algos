package com.algo.dp;

public class EqualAvgPartion {

	private void getEqualAvgPart(int []a,int index,int sum) {
		
		int pSum =0;
		int lSum = 0 ;
		for (int i = index+1; i<a.length-1;i++) {
			pSum=pSum+a[i];
			lSum=sum+a[i];
			
		}
		
		if (sum == (pSum%2)) {
			System.out.println();
		}
		getEqualAvgPart(a,index,sum+a[index]);
		
		
	}
	
	public static void main(String args[]) {
		int []a={1, 2, 3, 4, 5, 6};
	}
}
