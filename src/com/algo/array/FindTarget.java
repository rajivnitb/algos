package com.algo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindTarget {

	Map <Integer,Integer> findIndices(int []a,int target){
		int i = 0 ;
		int l = a.length-1;
		Map <Integer,Integer> targetMap=new HashMap<Integer,Integer>();
		while (i < l) {
			if (a[i]+a[l] == target) {
				targetMap.put(i,l);
				break ;
			}
			else if (a[i]+a[l] > target) {
				l-- ;
			}
			else if (a[i]+a[l] < target) {
				i++ ;
			}
		}
		
		return targetMap;
		
	}
	
	public static void main(String args[]) {
		int []a = {-8,1,4,6,10,45};
		
		
		Arrays.sort(a);
		for (Entry<Integer, Integer> e :new FindTarget().findIndices(a, 16).entrySet()) {
			System.out.println(e.getKey()+" *** "+e.getValue());
		}
		
		
	}
}
