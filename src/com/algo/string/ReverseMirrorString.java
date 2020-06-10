package com.algo.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReverseMirrorString {
	
	
	public static void main(String args[]){
		String s = "IM Rajiv";
		Stack <String> list = new Stack<String>() ;
		List <Stack> linkedList = new LinkedList<Stack>(); 
		
		for (int i=s.length()-1 ;i >= 0; i--){
			if(String.valueOf(s.charAt(i)).trim().isEmpty()){
				linkedList.add(list);
				list=new Stack<String>();
				list.add(String.valueOf(s.charAt(i)));
			}
			else{
		    list.add(String.valueOf(s.charAt(i)));
			}
		    
		}
		linkedList.add(list);
	
		for (Stack stack : linkedList)
		while(stack.size() != 0) {
		System.out.print(stack.pop());
		}
	}

}
