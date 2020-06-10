package com.algo.dp;

/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * @author RajivDevaraj
 *
 */
public class LCS {

	public int getLCS(String s1,String s2,int n,int m) {
		
		if (n == 0 || m == 0) {
			return 0;
		}
		
		
		if (s1.charAt(n-1) == s2.charAt(m-1)) {
			return 1+getLCS(s1,s2,n-1,m-1);
		}
		
		return Math.max(getLCS(s1,s2,n,m-1),getLCS(s1,s2,n-1,m));
	}
	
	public static void main(String args[]) {
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		
		System.out.println(new LCS().getLCS(s1, s2,s1.length(),s2.length()));
		
		
	}
}
