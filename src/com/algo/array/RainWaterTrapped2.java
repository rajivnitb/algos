package com.algo.list;

import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/rain-water-trapped/
 * @author Rajiv
 *
 */
public class RainWaterTrapped {

	class NodeDetail{
		private int index ;
	
		private int value ;
		
		public NodeDetail(int index,int value) {
			this.index=index;
			this.value=value;
		}
		
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	}
	
	
	public int getTotalVolume(int []a) {
		int totalVolume =0 ;
		Stack<NodeDetail> stack = new Stack<>();
		int min = Integer.MAX_VALUE ;
		int max = 0 ;
		for (int i = 0 ; i <= a.length-1 ; i++) {
			
						
			if (a[i] >0 && stack.isEmpty()) {
				 min = a[i];
		         stack.add(this.new NodeDetail(i,a[i]));
				 continue ;
			}
			
			if (a[i] > min) {
				max=a[i];
				stack.add(this.new NodeDetail(i,a[i]));
				
				totalVolume=totalVolume+calculate(stack);
				stack.clear();
				min=a[i];
				stack.add(this.new NodeDetail(i,a[i]));
				continue;
			}
			
			if (!stack.isEmpty())
			stack.add(this.new NodeDetail(i,a[i]));
			
		}
		return totalVolume;
	}
	
	private int calculate(Stack <NodeDetail> stack) {
		if (stack.peek().value > stack.firstElement().value) {
		NodeDetail ndMin=stack.remove(0);
	    NodeDetail ndMax =stack.pop();
		int max = ndMax.value;
        int maxIndex = ndMax.index;
       
        int min=ndMin.value;
        int minIndex=ndMin.index;
        
        int volume =Math.abs(maxIndex-minIndex)*Math.min(max,min)-1;
        
       for (NodeDetail stk : stack) {
    	   volume=volume-stk.getValue();    	   
       }
       return volume ;
		}else {
			
		    NodeDetail ndMax =stack.remove(0);
			
			int width = 0 ;
			int volume=0;
			while(!stack.isEmpty()) {
			   if (stack.get(0).value > 0) {
				   NodeDetail ndMin=stack.remove(0);
				   volume=Math.abs(ndMax.index-ndMin.index)*Math.min(ndMin.value,ndMax.value);
				   break ;
			   }
				
			}
			
			int []a = new int[stack.size()];
			int counter = 0 ;
			while (!stack.isEmpty()) {
				a[counter] = stack.remove(0).value;
			}
			
			return volume+getTotalVolume(a);
		}
	}
	
	public static void main(String args[]) {
		//int []a = {4,2,0,3,2,5};
		int []a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		RainWaterTrapped rT = new RainWaterTrapped();
		
		
		System.out.println(rT.getTotalVolume(a));
		
	}
}
