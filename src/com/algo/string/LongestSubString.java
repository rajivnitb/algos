package com.algo.string;

public class LongestSubString {

	private int findLongestSubString(String s,int maxCount,StringBuilder maxSB,int index) {
		if (s.length() < maxCount) {
			return maxCount;
		}
		StringBuilder tempsb = new StringBuilder();
		int tempCount = 0;
	    for (int i = 0 ; i < s.length()-1 ; i++) {
	    	if (tempsb.toString().contains(Character.toString(s.charAt(i)))){
	    		break;
	    	}
	    	else {
	    		tempCount ++;
	    		tempsb.append(s.charAt(i));
	    	}
	    } 
	    
	    if (tempCount > maxCount) {
	    	maxCount=tempCount;
	    	maxSB=tempsb;
	    }
		
		return findLongestSubString(s.substring(index+1), maxCount, maxSB,index+1);
	}
	
	public static void main(String args[]) {
		String s = "abcabcebb";
		System.out.println(new LongestSubString().findLongestSubString(s,0,new StringBuilder(),0));
	}
}
