package com.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * https://www.interviewbit.com/problems/add-one-to-number/
 * @author RajivDevaraj
 *
 */
public class PlusOne {
	
	public ArrayList<Integer> plusOne(int []a) {
		int nextIndex = 0 ;
		boolean firstInstance = true ;
		for (int i = a.length-1 ; i >= 0 ;i--) {
			if (firstInstance) {
				int tempnextIndex=(a[i]+1)/10;
				a[i]=(a[i]+1+nextIndex)%10;
				nextIndex=tempnextIndex;
				firstInstance=false;
			}else {
				int tempnextIndex=(a[i]+nextIndex)/10;
				a[i]=(a[i]+nextIndex)%10;
				nextIndex=tempnextIndex;
				
			}
		}		
		
		ArrayList<Integer> list = new ArrayList<>();
		if (nextIndex > 0) {
		
		list.add(nextIndex);
		}
		for (Integer i : a) {
			list.add(i);
		}
	  
		return list;
    }

	public static void main(String args[]) {
		int []a= {0,1,2,4};
		System.out.println(new PlusOne().plusOne(a));
	}
	
}
