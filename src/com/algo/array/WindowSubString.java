package com.algo.array;

import java.util.ArrayList;
import java.util.List;

public class WindowSubString {
	
    public static String minWindow(String s, String t,List <String> list) {
    	int counter = -1 ;
    	String temp = "" ;
    	boolean flag = false ;
    	String foundString = "";
        List <String> occurrence =new ArrayList<String>();
    	if (s.length() < t.length()) {
    		if (!list.isEmpty()) {
    			return list.get(0);
    		}
    		else {
    			return "";
    		}
    	}
    	for (int i = 0 ; i <= s.length()-1 ; i++) {
        	if (t.contains(String.valueOf(s.charAt(i)))){
        		if (occurrence.isEmpty()) {
        			occurrence.add(String.valueOf(s.charAt(i)));
        		}
        		else {
        			if(occurrence.contains(String.valueOf(s.charAt(i)))) {
        				temp = s.substring(i);
        				occurrence.clear();
        				return minWindow(temp, t,list);
        			}
        			else {
        				occurrence.add(String.valueOf(s.charAt(i)));
        			}
        		}
         		counter ++ ;
        		
        	}
        	
        	if (counter == 1 & !flag) {
        		temp = s.substring(i);
        		flag=true;
        	}
        	if (counter == t.length()-1) {
        		foundString=s.substring(0,i+1);
        		occurrence.clear();
        		break ;
        	}
        }
        if (counter == t.length()-1 ) {
        	if (!list.isEmpty()) {
        		if (list.get(0).length() > foundString.length()) {
        				list.add(0,foundString);
        		}
        	}
        	else {
        		list.add(0,foundString);
        	}
       
        }
    	return minWindow(temp, t,list);
    }

	public static void main(String args[]) {
	   String S = "ADOBECODEBANC";
	   String T = "ABC";
	   List <String> list = new ArrayList<String>();
	   System.out.print(minWindow(S,T,list));

	}
	
}
