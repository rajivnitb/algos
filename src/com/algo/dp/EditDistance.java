package com.algo.dp;

public class EditDistance {
	
	public int getDistance(String s1,String s2) {
		
		if (s1.length() <= 0 ) {
			return s2.length();
		}
		
		if (s2.length() <= 0 ) {
			return s1.length();
		}
		
		
		if (s1.charAt(0) == s2.charAt(0)) {
			return getDistance(s1.substring(1),s2.substring(1));
		}
		
		
		
		
		return Math.min(Math.min(getDistance(s1,s2.substring(1))+1
				,getDistance(s1.substring(1),s2)+1),
				getDistance(s1.substring(1),s2.substring(1)+1));
		
		
		
		
	}	
	
	public static void main(String [] args) {
		String s1 = "sunday";
		String s2 = "saturday";
	  
		System.out.println(new EditDistance().getDistance(s1, s2));
		
	}
}
