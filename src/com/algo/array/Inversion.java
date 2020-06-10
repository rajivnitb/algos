package com.algo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Inversion {

	
	private Map<Integer,List<Integer>> getInversionPair(int []a,Map<Integer,List<Integer>> map,int low,int high){
	    if (low < high ) {
	    
		int mid = (low+high)/2;
	    getInversionPair(a,map,low,mid);
	    getInversionPair(a,map,mid+1,high);
	    findInversion(a,map,low,mid,high);
	
	    
	    }
		return map;
		
	}
	
	private void findInversion(int []a,Map<Integer,List<Integer>> map,int low,int mid,int high) {
		
		int l[] = new int[mid-low+1];
		
		int r[] = new int[high-mid];
		
		for (int i=0 ; i <l.length ; i++) {
			l[i]=a[low+i];
		}
		
		for (int i=0 ; i <r.length ; i++) {
			r[i]=a[mid+1+i];
		}
		
		int indexL = 0; 
		int indexR= 0 ;
		while (r.length-1 >= indexR && l.length-1 >= indexL ) {
			if (l[indexL] > r[indexR]) {
				if (map.isEmpty()) {
				  ArrayList <Integer>as =new ArrayList<Integer>();
		          as.add(l[indexL]);
				  map.put(r[indexR],as);
				}
				else {
					if(map.containsKey(l[indexL])) {
						map.get(l[indexL]).add(r[indexR]);
					}
					else
					{
						  ArrayList <Integer>as =new ArrayList<Integer>();
				          as.add(r[indexR]);
						  map.put(l[indexL],as);
					}
				}
                if (indexR >= r.length-1  && indexL <= l.length-1) {
					indexL ++;
					indexR =0;
				}
                else {
				   indexR ++;
                }
			}
			else {
				if (indexR < r.length-1) {
					indexR ++ ;
				}
				else {
				indexL ++ ;
				indexR = 0;
				}
				
				
			}
			
		}
	}
	
    
	public static void main (String args[]) {
		//int []a = {1,20,6,4,5};
		int []a ={2, 4, 1, 3, 5};
		Map <Integer,List<Integer>>map=new HashMap<Integer,List<Integer>>();
		Map <Integer,List<Integer>> opMap=new Inversion().getInversionPair(a, map,0,a.length-1);
		for (Entry <Integer,List<Integer>>e : opMap.entrySet()) {
			System.out.println(e.getKey()+" >> "+e.getValue());
		}
	}
}
