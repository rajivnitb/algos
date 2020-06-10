package com.algo.dp;

public class Jumps {

	public int getCount(int []a,int index) {
		if (index == a.length-1) {
			return 0;
		}
		if (index > a.length-1) {
			return Integer.MAX_VALUE;
		}
		
		int value = a[index];
		int min = Integer.MAX_VALUE;
		for (int i =index+1;i<=a.length-1 && i<=index+value;i++) {
			int jumps=getCount(a,i);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min) 
                min = jumps + 1; 
			System.out.println(a[i]+"==>"+min);
		}
		
	   return min;
		
		
	}
	
	
	public static void main(String args[]) {
		int [] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(Integer.MAX_VALUE);
		System.out.println(new Jumps().getCount(a,0));
	}
}
