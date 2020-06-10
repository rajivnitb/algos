package com.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-product-subarray/
 * @author RajivDevaraj
 *
 */
public class MaxSubArray {

	private static int get(int []a,int index,int prod,Integer maxProd,boolean flag) {
		
		if (index > a.length-1) {
			return maxProd;
		}
		if (index == 0) {
			maxProd=a[index];
			prod=maxProd;
		}else {
			if (!flag) {
				if (a[index] == 0) {
					return maxProd;
				}
			prod=prod*a[index];
			int indexProd=Math.max(prod,a[index]);
		    maxProd=Math.max(maxProd,indexProd);
			}else {
				if (a[index] == 0) {
					return get(a,index+1,prod,maxProd,true);
				}else {
				prod=a[index];
				maxProd=Math.max(maxProd,prod);
				}
			}
		}
		
		
		return Math.max(get(a,index+1,prod,maxProd,false),get(a,index+1,prod,maxProd,true));
		
	}
	
	public static void main(String args[]) {
		int [] a = {0, -4, 1, 8, -1, 2, 0, 9, 5, 4, -7, 1, 0, 3, 3, -6, -9, 1, 0, -2, -3, -6, -8, 7, 0, 9, -7, -9, -1, 8 };
		//int []a={-2,-9,0,2,8};
		System.out.println(get(a, 0, a[0],null,false));
	}
}
