package com.algo.dp;

import com.algo.tree.Tree;
import com.algo.tree.Tree.Node;

/**
 * https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
 * @author RajivDevaraj
 *
 */
public class MaxSumPathTree {
	
	private Integer maxsum =Integer.MIN_VALUE;
	
	int findMaxSumPathTree(Node node) {
		findMaxSum(node);
		return maxsum ;
	}
	
	public int findMaxSum(Node node) {

		if (node == null) {
			return 0;
		}

		int leftNode = findMaxSum(node.left);
		int rightNode = findMaxSum(node.right);

		int value = Math.max(Math.max(leftNode,rightNode) + node.value, node.value);

		int maxValue = Math.max(value, node.value +leftNode +rightNode);

		maxsum = Math.max(maxsum, maxValue);

		return value;

	}
	 
	
	public static void main(String args[]) {
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(10);
		node.left = tree.new Node(10);
		node.right = tree.new Node(20);
		node.left.left = tree.new Node(8);
		node.left.right = tree.new Node(12);
		node.right.left = tree.new Node(25);
		node.right.right = tree.new Node(16);	
	    MaxSumPathTree maxPT=new MaxSumPathTree();
		System.out.println(maxPT.findMaxSumPathTree(node));
		
	}
	
}
