package com.algo.tree;

import com.algo.tree.Tree.Node;

/**
 * https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
 * 
 * @author RajivDevaraj
 *
 */
public class InOrderCartesian {

	public Node constructCartesianTree(int []a,Tree tree,Node node,int index) {
		int tmpLength = 0;
		if (a.length-1-index+1 >= 2) {
			tmpLength = 2;
		} else {
			if (a.length-index <= 0) {
				return node;
			} else {
				tmpLength = a.length-1 -index+1;
			}
		}

		Node left  =null;
		Node root = null;
		Node right = null ;
		int counter = 0;
		for (int i =index; i <=a.length-1; i++) {
			if (counter > 2) {
				break;
			}
			if (counter == 0) {
				left = tree.new Node(a[i]);
                if (node != null) {
                	left.left=node;
                }
			}
			if (counter == 1) {
				root = tree.new Node(a[i]);
				root.left=left;
			}
			if (counter == 2) {
				right = tree.new Node(a[i]);
			    root.right=right;
			}
			counter ++ ;
		}
		index=index+tmpLength+1;
		if (root == null)
		return constructCartesianTree(a,tree,left,index);
		else
			return constructCartesianTree(a,tree,root,index);
	}
	
	void printNode(Node node) {
		if (node == null) {
			return ;
		}
		printNode(node.left);
		System.out.println(node.value);
		printNode(node.right);
	}

	public static void main(String args[]) {
		int arr[] = { 3, 7, 4, 8};
		Tree tree = new Tree();
		InOrderCartesian inOrder = new InOrderCartesian();
		Node node=inOrder.constructCartesianTree(arr,tree,null,0);
		inOrder.printNode(node);
		
 	}
}
