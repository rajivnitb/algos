package com.algo.string;

/**
 * https://www.interviewbit.com/problems/longest-common-prefix/
 * @author RajivDevaraj
 *
 */
public class LCP {
	
	static String commonPrefixUtil(String str1, String str2) { 
        String result = ""; 
        int n1 = str1.length(), n2 = str2.length(); 
  
        for (int i = 0, j = 0; i <= n1 - 1 &&  
                j <= n2 - 1; i++, j++) { 
            if (str1.charAt(i) != str2.charAt(j)) { 
                break; 
            } 
            result += str1.charAt(i); 
        } 
        return (result); 
    } 

	String getLCP(String []arr,int low,int high) {
        if (low == high) {
        	return arr[high];
        }
		int mid=(low+high)/2;
		if (mid < high) {
		String L = getLCP(arr,low,mid);
		String R = getLCP(arr,mid+1,high);
		
		return commonPrefixUtil(L,R);
		}
		return null ;
		
	}
	public static void main(String args[]) {
		String arr[] = {"geeksforgeeks", "geeks", 
	            "geek", "geezer","geez","get"}; 
		System.out.println(new LCP().getLCP(arr, 0, arr.length-1));
		
	}

}
