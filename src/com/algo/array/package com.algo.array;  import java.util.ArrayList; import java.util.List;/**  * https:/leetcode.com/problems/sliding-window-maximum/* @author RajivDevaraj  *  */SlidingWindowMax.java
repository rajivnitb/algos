package com.algo.array;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * @author RajivDevaraj
 *
 */
public class SlidingWindowMax {

	public List<Integer> getSolution(int []a,int temp) {
		int k=temp ;
		int index = 0 ;
		int currentIndex = 0 ;
		int max=Integer.MIN_VALUE;
		ArrayList <Integer> list = new ArrayList<Integer>();
		while (index < a.length && k >= 0) {
		  max=Math.max(max,a[index]);
		  k-- ;
		  index++;
		  
		  if (k == -1) {
			  list.add(max);
			  currentIndex=currentIndex+1;
			  index=currentIndex;
			  k=temp ;
		  }
		  
		}
		return list;
	}
	
	public static void main(String args[]) {
		int []a= {1,3,-1,-3,5,3,6,7};
		int k=3;
		System.out.println(new SlidingWindowMax().getSolution(a,2));
	}
}
