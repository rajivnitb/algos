package com.algo.string;

/**
 * https://www.interviewbit.com/problems/count-and-say/
 * @author RajivDevaraj
 *
 */
public class CountSay {
	
	public String countAndSay(int i,int initialVal,String s) {
		if (i == initialVal ) {
			return s ;
		}
		s=cal(String.valueOf(s));
		return countAndSay(i, initialVal+1, s);
		
    }
	
	private String cal(String s) {
		String prev = "";
		String finalString = "";
		String lastNum = "" ;
		for (int j = 0 ; j <= s.length()-1 ; j++) {
			String temp =String.valueOf(s.charAt(j));
			if (!prev.isEmpty() && lastNum.equals(temp) ) {
				prev+=temp;
				lastNum =temp;
				
			}else {
				if (prev.isEmpty()) {
					prev = temp;
					lastNum=temp ;
				}else {
					finalString+=prev.length()+String.valueOf(prev.charAt(0));
					prev="";
					prev=temp;
					lastNum = temp ;
				}
			}
			
		}
		
		finalString+=prev.length()+String.valueOf(prev.charAt(0));
		
		return finalString ;
	}

	

	public static void main(String args[]) {
		System.out.println(new CountSay().countAndSay(7,1,"1"));
	}
}
