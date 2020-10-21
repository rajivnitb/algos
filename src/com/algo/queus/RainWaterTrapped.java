package com.algo.queus;

/**
 * https://www.interviewbit.com/problems/rain-water-trapped/
 * 
 * @author RajivDevaraj
 *
 */
public class RainWaterTrapped {
	
	int counter = 0 ;
	static int arrayMaxIndex=Integer.MIN_VALUE;

	private int scanMaxIndex(int []a,int index) {
		int max = Integer.MIN_VALUE;
		int orgindex = 0 ;
		for (int i = index ; i < a.length-1;i++) {
			 if (max <= a[i]) {
				 max=a[i];
				 orgindex=i;
			 }
			 			
		}
		return orgindex ;
	}
	
	public int getMaxRainTrapped(int[] a,int max,int current,int maxIndex,int prevMaxIndex,int next) {
		
		if (a[current] < a[current+1]) {
			return getMaxRainTrapped(a, a[current+1], current+1, current+1,current,current+2);
		}
		
		if (current >= a.length-1 || next >= a.length-1) {
			return counter;
		}
		
		
		
		
		for (int i = current ; i <= a.length-1;i++) {
			if (arrayMaxIndex == i && current == i) {
				continue;
			}
			if (prevMaxIndex == i) {
				continue;
			} 
			if (current+1 == i) {
				if (a[current] >= a[i]) {
					//current=i;
					continue;
				}
				
			}
			if (max == a[i]) {
				maxIndex=i;
			}
					
			if (max < a[i]) {
 				maxIndex=i;
				max=a[i];
				break;
			}
			
		}
		
		int maxDelta = Math.min(a[current],a[maxIndex]);
		int tmpCounter = 0 ;
		for (int i=current+1 ; i <maxIndex ; i++) {
			tmpCounter=tmpCounter+Math.abs(a[i]-maxDelta);
		}
		
		if (arrayMaxIndex <= maxIndex) {

			current = maxIndex;
            prevMaxIndex=arrayMaxIndex;
			if (current > a.length - 1) {
				return counter;
			}
			arrayMaxIndex = scanMaxIndex(a, current+1);
			maxIndex = current;
			max = Integer.MIN_VALUE;
		}
		
		counter=counter+tmpCounter+getMaxRainTrapped(a,max,maxIndex,maxIndex,prevMaxIndex,maxIndex+1);
		
		return counter ;
	}

	

	

	public static void main(String args[]) {
	//	int[] a = { 4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		   int []a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		RainWaterTrapped rainWT = new RainWaterTrapped();
		arrayMaxIndex=rainWT.scanMaxIndex(a,0);
	
       System.out.println(rainWT.getMaxRainTrapped(a,0,0,0,0,1));
	}

}
