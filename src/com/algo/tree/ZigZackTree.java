package com.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZackTree {

	public List<List<Integer>> zigzagLevelOrder(Tree.Node root,List<List<Integer>> list,LinkedList <Tree.Node> stack,boolean isLeft) {
		
		if (!list.isEmpty() && stack.isEmpty()) {
			return list ;
		}
		
		if (list.isEmpty()) {
			List <Integer> rtList = new ArrayList<Integer>();
			rtList.add(root.value);
			list.add(rtList);
			list.add(addList(root,false));
			stack = new LinkedList<Tree.Node>();
			stack.add(root.left);
			stack.add(root.right);
			return zigzagLevelOrder(root,list,stack,false);
		}
       
		LinkedList <Tree.Node>tmpList = null ;
		List <Integer> tmpIntegerList = null ;
		if (isLeft) {
			isLeft=false;
		}
		else {
			isLeft=true;
		}
		while (!stack.isEmpty()) {
			if (tmpList == null) {
				Tree.Node tempNode=stack.pop();
				tmpList=addStack(tempNode);
				tmpIntegerList=addList(tempNode,isLeft);
			    
				
			}
			Tree.Node tempNode=stack.pop();
			tmpList.addAll(addStack(tempNode));
			tmpIntegerList.addAll(addList(tempNode,isLeft));
			
		}
		list.add(tmpIntegerList);
		
		return zigzagLevelOrder(root,list,tmpList,isLeft);
		
		
	}
	
	private LinkedList <Tree.Node> addStack(Tree.Node root){
		LinkedList <Tree.Node> rtList = new LinkedList<Tree.Node>();
		if (root == null) {
			return rtList ;
		}
		if (root.left != null) {
		rtList.add(root.left);
		}
		if (root.right !=null) {
		rtList.add(root.right);
		}
		return rtList;
	}
	
	private List<Integer> addList(Tree.Node root,boolean isLeft){
		List <Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		if (isLeft) {
			if (root.left != null) {
				list.add(root.left.value);
			}
			if (root.right != null) {
				list.add(root.right.value);
			}
			
		} else {
			if (root.right != null) {
				list.add(root.right.value);
			}
			if (root.left != null) {
				list.add(root.left.value);
			}
		}
		return list ;
	}

	public static void main(String args[]) {
          Tree tree = new Tree();
          Tree.Node node = tree.new Node(1);
          node.left = tree.new Node(2); 
          node.right = tree.new Node(3); 
          node.left.left = tree.new Node(7); 
          node.left.right = tree.new Node(6); 
          node.right.left = tree.new Node(5); 
          node.right.right = tree.new Node(4);
          
          
          List<List<Integer>> list=new ZigZackTree().zigzagLevelOrder(node,new ArrayList<List<Integer>>(),new LinkedList<Tree.Node>(),false);
          System.out.println(list);
	}
}
