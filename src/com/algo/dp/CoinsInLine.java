package com.algo.dp;

/**
 * https://www.interviewbit.com/problems/coins-in-a-line/
 * @author RajivDevaraj
 *
 */
public class CoinsInLine {

	

	

	public int getMaxCoin(int []a,int i,int j,int finalval) {
		//either ends but figure out if i take one end will it allow me to take higher index if then
		
		
		
		
		int x,y,z,w;
			  // Here x is value of F(i+2, j), 
             // y is F(i+1, j-1) and z is 
             // F(i, j-2) in above recursive formula 
			 w = ((i+2) <= (j)) ? a[i + 2] : 0; 
             x = ((j) >= (i+1)) ? a[j] : 0; 
             y = ((j-1) >= (i+1)) ? a[i+1] : 0; 
             z = ((j-2) >= (i)) ? a[j- 2] : 0; 

            finalval=Math.max(a[i] + Math.min(w,x),  
                                    a[j] + Math.min(y, z)); 
            getMaxCoin(a, i+2, j,finalval);
            getMaxCoin(a, i, j+1,finalval) ;            
        
		return finalval; 
		
		
		
	}
	
	
	
	
	
	public static void main(String args[]) {
		int[] a = { 8,15,3,7 };
		System.out.println(new CoinsInLine().getMaxCoin(a,0,a.length-1,0));
	}
}
