package com.algo.dp;

public class DistinctSubSeq {

	
	static int getCount(String sampleStr, String matchStr, int sampleStrlen, int matchStrlen) 
    { 
	  
		if ((sampleStrlen == 0 && matchStrlen == 0) || matchStrlen == 0) {
			return 1 ;
		}
		
		if (sampleStrlen == 0) {
			return 0 ;
		}
		
		
		
		if (sampleStr.charAt(sampleStrlen-1) == matchStr.charAt(matchStrlen-1)) {
			return getCount(sampleStr, matchStr, sampleStrlen-1, matchStrlen-1)+
					getCount(sampleStr, matchStr, sampleStrlen-1, matchStrlen);
		}else {
			return getCount(sampleStr, matchStr, sampleStrlen-1, matchStrlen);
		}

			
      		
	} 
	
	public static void main(String args[]) {
		String sampleStr="rabb";
		String matchStr="rab";
		System.out.println(DistinctSubSeq.getCount(sampleStr,matchStr,sampleStr.length(),matchStr.length())) ;
	}
}
