package com.algo.tree;

import com.algo.tree.FlipBT.RelationShip;

public class Tree {

	Node root;
	

	public class Node implements Cloneable{
		public Node left = null;
		public Node right = null;
		public Node next = null ;
		
		public int value;

		public Node(int value) {
			this.left = null;
			this.right = null;
			this.value = value;
			this.next=null;
		}
		
		public void map(Node node,Node next) {
			while(node != null && node.next !=null) {
				node=node.next;
			}
			node.next=next;
		}
		
		public Object clone()throws CloneNotSupportedException{  
			return super.clone();  
			}  
		
		
	}

	Node add(Node node, int value) {

		if (node == null) {
			node = new Node(value);
			return node;
		}

		if (value < node.value)
			node.left = add(node.left, value);
		else if (value > node.value)
			node.right = add(node.right, value);
		return node;
	}
	
	Node add(int value,Node node,RelationShip rs) {
		if (node == null) {
			node = new Node(value);
			root=node;
			return node;
		}
	    
		root=locateNodeAndMap(node,rs.leftChild.value,rs,value);
		
		
		
		return root;
	}
	
	Node locateNodeAndMap(Node node,int childValue,RelationShip rs,int currentNodeValue) {
		if (node == null) {
			return null;
		}
		if (node.value == childValue) {
			node.right=new Node(currentNodeValue);
			node.left=new Node(rs.rightChild.value);
			return node ;
		}
		
		
		locateNodeAndMap(node.left,childValue,rs,currentNodeValue);
		locateNodeAndMap(node.right,childValue,rs,currentNodeValue);
	    return node;
		
	}

}
