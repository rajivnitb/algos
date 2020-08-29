package com.algo.tree;

import com.algo.tree.Tree.Node;

/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 * 
 * @author RajivDevaraj
 *
 */
public class MaxProdTree {

	long sum = 0;
	long maxProd = Integer.MIN_VALUE;

	public Node totalSum(Node node) {
		if (node == null) {
			return null;
		}

		totalSum(node.left);
		totalSum(node.right);

		sum = sum + node.value;
		return node;
	}

	private void maxProd(Node givenNode, long tmpSum, Long nodeSum) {

		if (givenNode == null) {
			return;
		}

		maxProd(givenNode.left, tmpSum, nodeSum);
		maxProd(givenNode.left, tmpSum-givenNode.value,nodeSum+givenNode.value);
		maxProd(givenNode.right, tmpSum, nodeSum);
		maxProd(givenNode.right, tmpSum-givenNode.value,nodeSum+givenNode.value);
		

		tmpSum = tmpSum - givenNode.value;
		long tmpProd = (nodeSum+givenNode.value)* tmpSum;
		maxProd = Math.max(maxProd, tmpProd);

	}

	public static void main(String args[]) {
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(1);
		node.left = tree.new Node(2);
		node.right = tree.new Node(3);
		node.left.left = tree.new Node(4);
		node.left.right = tree.new Node(5);
		node.right.left = tree.new Node(6);
		//node.right.right = tree.new Node(7);
		MaxProdTree prod = new MaxProdTree();
		prod.totalSum(node);
		prod.maxProd(node, prod.sum,Long.valueOf(0));
		System.out.println(prod.sum);
		System.out.println(prod.maxProd);
	}
}
