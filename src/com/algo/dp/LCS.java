package com.algo.dp;

/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * @author RajivDevaraj
 *
 */
public class LCS {

	private int getLCS(String s1,String s2) {
		
		if (s1.length() <= 0|| s2.length() <=0) {
			return 0;
		}
		
		if (s1.charAt(0) == s2.charAt(0)) {
			return 1+getLCS(s1.substring(1),s2.substring(1));
		}
		
		return Math.max(getLCS(s1.substring(1),s2.substring(1)),
				getLCS(s1.substring(1),s2));
		
		
	}
	
	public static void main(String args[]) {
		String s1="zxabcdezy";
		String s2 = "yzabcdezx";
		
		LCS lcs = new LCS();
		System.out.println(lcs.getLCS(s1, s2));
	}
}
