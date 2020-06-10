package com.algo.array;

public class SearchROA {

	
	public int findIndex(int []a,int i) {
		int mid=a.length/2;
		if (a[mid] == i) {
			return mid ;
		}
		if (a[mid] > a[mid+1] && a[mid] > a[mid-1]) {
			if (i <= a[a.length-1] && i < a[mid]) {
				return findIndexBS(a,a.length-1,mid+1,i);
			}
			else if (i < a[mid] && i >= a[0]){
				return findIndexBS(a,mid-1,0,i);
			}
		}
		
		return -1;
	}
	
	private int findIndexBS(int []a,int high,int low,int element) {
		if (low <= high) {
			int mid = (low+high)/2;
			if (a[mid] == element) {
				return mid ;
			}
			if (a[mid] > element) {
				return findIndexBS(a,mid-1,low,element);
			}
			else {
				return findIndexBS(a,high,mid+1,element);
			}
		}
		return -1;
		
	}
	
	public static void main(String []args) 
	{
		int []a = {4,5,6,7,0,1,2};
		System.out.println(new SearchROA().findIndex(a,2));
	}
}
