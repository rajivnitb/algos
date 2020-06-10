package com.algo.dp;

/**
 * https://www.interviewbit.com/problems/longest-valid-parentheses/
 * @author RajivDevaraj
 *
 */
public class LongestValidParentheses {

	private static int count = 0;
	
	private static int getLongestParenthess(String s,int index,String current) {
		
		if (index > s.length()-1) {
			return count;
		}
		
		if (current == null && String.valueOf(s.charAt(index)).equals("(")) {
			current=String.valueOf(s.charAt(index));
		}
		
		if (current != null) {
			if (current.equals("(") && String.valueOf(s.charAt(index)).equals(")")) {
				count = count + 1;
				current = ")";
			} else if (current.equals(")") && String.valueOf(s.charAt(index)).equals("(")) {
				current = "(";
			}
		}
		
		for (int i=index+1;i<=s.length()-1;i++) {
			getLongestParenthess(s.substring(i,s.length()-1),i,current);
		}
		
		return count*2 ;
		
	}
	
	
	public static void main(String args[]) {
		String s = "()(()))))";
		System.out.println(getLongestParenthess(s,0,null));
	}
}
