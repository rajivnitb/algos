package com.algo.array;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 * @author RajivDevaraj
 *
 */
public class FindMinROA {

	public int getMin(int []a,int start,int end) {
		
		if(start == end){
            return a[start];
        }
		
		if (start >= end) {
			return a[start];
		}
		
		if (a[end-1] > a[end] ) {
			return a[end];
		}
		
		
		int mid=(start+end)/2;
		return Math.min(getMin(a,start,mid),getMin(a,mid+1,end));
		
		
	}
	
	public static void main(String args[]) {
		int []a = {4,5,6,7,8,9,1,2};
		System.out.println(new FindMinROA().getMin(a,0,a.length-1));
		
	}
}
