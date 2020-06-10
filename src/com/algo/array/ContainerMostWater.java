package com.algo.array;

public class ContainerMostWater {

	
	public int maxArea(int []a,int low,int high) {
		int maxArea = 0 ;
		int tempTall = 0;
		while(low <= high) {
			if (a[low] > a[high]) {
				if (tempTall < a[low]) {
					tempTall = a[low];
				}
				maxArea=Math.max(maxArea,(a[high]*(high-low)));
			}
			else {
				maxArea=Math.max(maxArea,(a[low]*(high-low)));
				if (tempTall < a[high]) {
				  tempTall=a[high];
				}
			}
			
			if (a[low] < tempTall || a[low] != tempTall) {
				low++;
			}
			else if(a[high] < tempTall || a[high] != tempTall) {
				high --;
			}
			if (a[high]==a[low]) {
				if ((a.length-high)> low) {
					high -- ;
				}
				else if (low > (a.length-high)) {
					low -- ;
				}
				else 
				{
					high --;
				}
			}
		}
		return maxArea ;
	}
	
	
	public static void main(String args[]) {
		int []a = {1,8,6,2,5,4,8,3,7};
		System.out.println(new ContainerMostWater().maxArea(a,0,a.length-1));
	}
}
