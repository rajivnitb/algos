package com.algo.tree;

import com.algo.tree.Tree.Node;


public class SymmetricBT {
	
	public Node doMirrorTree(Node node) {
		if (node == null) {
			return node;
		}else {
			System.out.println(node.value);
		}
		
		Node tmpLeft =null;
		Node tmpRight = null;
		if (node.left != null) {
			tmpRight=node.left;
		}
		if (node.right != null) {
			tmpLeft=node.right;
		}
		node.left=tmpLeft;
		node.right=tmpRight;
		
		if (node.left != null) 
		System.out.println(node.left.value);
		
		if (node.right != null) 
		System.out.println(node.right.value);
		
		doMirrorTree(node.left);
		doMirrorTree(node.right);
		
		return node;
	}
	

	public static void main(String args[])  {
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(1);
		node.left = tree.new Node(2);
		node.right = tree.new Node(2);
		node.left.left = tree.new Node(3);
		node.left.right = tree.new Node(4);
		node.right.left = tree.new Node(4);
		node.right.right = tree.new Node(5);
		
		Tree.Node node1 = tree.new Node(1);
		node1.left = tree.new Node(2);
		node1.right = tree.new Node(2);
		node1.left.left = tree.new Node(3);
		node1.left.right = tree.new Node(4);
		node1.right.left = tree.new Node(4);
		node1.right.right = tree.new Node(3);
		
	
		System.out.println(new IdenticalBinaryTrees().isIdentical(node,new SymmetricBT().doMirrorTree(node1)));
		
	}
	
}
