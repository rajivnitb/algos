package com.algo.queus;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearSME {

	private Stack <Integer>stack = new Stack<Integer>();
	private List<Integer> list = new ArrayList<>();
	
	private void getNearSME(int []a,int index) {
		if (index > a.length-1) {
			return ;
		}
		
		if (stack.isEmpty()) {
			stack.push(a[index]);
			System.out.print(-1+",");
		}else {
			while (!stack.isEmpty() && stack.peek() >= a[index]) {
				stack.pop();
			}
			if (!stack.isEmpty() && a[index] > stack.peek()) {
				System.out.print(stack.peek()+",");
			}else {
				System.out.print(-1+",");
			}
			stack.push(a[index]);
		}
		getNearSME(a, index+1);
	}
	
	public static void main(String args[]) {
		int []a= {4, 5, 2, 10, 8};
		new NearSME().getNearSME(a, 0);
	}
}
