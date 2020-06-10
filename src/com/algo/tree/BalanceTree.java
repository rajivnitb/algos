package com.algo.tree;

import java.util.Map;

import com.algo.tree.Tree.Node;

public class BalanceTree {

	public boolean isBalanced(Node node) {
		
		int left=computeDepth(node.left);
		System.out.println("left :"+left);
		int right=computeDepth(node.right);
		System.out.println("right :"+right);
		
		if (Math.abs(left-right) > 1)
		return false;
		else
			return true;
		
	}
	
	private int computeDepth(Node node) {
	   
		if (node == null) {
			return  0;
		}
		
		return 1+Math.max(computeDepth(node.left),computeDepth(node.right));
		
	}
	
	public static void main(String args[]) {
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(1);
		node.left = tree.new Node(2);
		node.right = tree.new Node(3);
		node.left.left = tree.new Node(4);
		node.left.right = tree.new Node(5);
		node.right.left = tree.new Node(6);
		node.right.right = tree.new Node(7);
		node.right.right.right= tree.new Node(8);
		System.out.println(new BalanceTree().isBalanced(node));
	}
	
}
