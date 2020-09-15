package com.algo.array;

/**
 * https://www.interviewbit.com/problems/rain-water-trapped/
 * 
 * @author RajivDevaraj
 *
 */
public class RainWaterTrapped {

	public int getMaxRainTrapped(int[] a) {
		int end=a.length-1;
		int start=1;
		
		int maxHeight= Integer.MIN_VALUE;
		int maxHeightIndex = 0;
		for (int i=0;i<a.length-1;i++) {
			maxHeight=Math.max(maxHeight,a[i]);
			if (maxHeight > a[maxHeightIndex]) {
				maxHeightIndex=i;
			}
			
		}
		
		
		int count = 0 ;
		while (start <= maxHeightIndex) {
             
			if (a[start] < a[start+1]) {
				count+=Math.abs(a[start]-a[start+1]);
				
			}
			start++;

		}

		if (maxHeightIndex != end) {
			while(end > maxHeightIndex) {
				
				if (a[end] > a[end-1]) {
					count+=Math.abs(a[end]-a[end-1]);
					
				}
				end--;
				
			}
		}
		return count ;
	}

	

	

	public static void main(String args[]) {
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 1,2, 1, 2, 1 };
        System.out.println(new RainWaterTrapped().getMaxRainTrapped(a));
	}

}
