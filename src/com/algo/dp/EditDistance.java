package com.algo.dp;

public class EditDistance {
	
	private int min(int x,int y,int z) {
		  if (x <= y && x <= z) 
	            return x; 
	        if (y <= x && y <= z) 
	            return y; 
	        else
	            return z; 
	}
	
	private int getDistance(String str1,String str2,int n,int m) {
		
		if (n == 0) {
			return m;
		}
		
		if (m == 0) {
			return n;
		}
		
		if (str1.charAt(n-1) == str2.charAt(m-1)) {
			return getDistance(str1,str2,n-1,m-1);
		}
		
		return 1+min(getDistance(str1,str2,n,m-1),getDistance(str1,str2,n-1,m),getDistance(str1,str2,n,m));
		
		
	}
	
	public static void main(String args[]) {
		String str1 = "Anshuman";
		String str2 = "Antihuman";
		
		System.out.println(new EditDistance().getDistance(str1, str2,str1.length(),str2.length()));
		
		
	}
}
