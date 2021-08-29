package com.algo.dp;

public class EditDistance {

	public static int getMinDistance(String word1,String word2) {
		
		int [][] a = new int [word1.length()+1][word2.length()+1];
		
		for (int i = 1 ; i <= word1.length() ; i++) {
			a[i][0]=1+a[i-1][0];
		}
		
		for (int i = 1 ; i <= word2.length() ; i++) {
			a[0][i]=1+a[0][i-1];
		}
		
		for (int i = 1 ; i <= word1.length() ; i++) {
	      for (int j = 1 ; j <= word2.length() ; j++) {
	    	  
	    	  if (word1.charAt(i-1) == word2.charAt(j-1)) {
	    		  a[i][j]=a[i-1][j-1];
	    	  }else {
	    		  a[i][j]=Math.min(a[i-1][j],Math.min(a[i-1][j-1],a[i][j-1]))+1;
	    	  }
	    	 
	    	  
	      }		
		}
		
		
		return a[word1.length()][word2.length()];
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(getMinDistance("horse","ros"));
		
	}
}
