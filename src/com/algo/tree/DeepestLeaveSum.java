package com.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.algo.tree.Tree.Node;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * @author Rajiv Devaraj
 *
 */
public class DeepestLeaveSum {
	
	private static Queue<Integer> q = new LinkedList<>();

	private int maxSum(Tree.Node node){
		int max = 0 ;
		if (node.left == null && node.right == null) {
			return node.value;
		}
		if (node.left != null) {
			findDeepestLeave(node.left);
			 max+=q.poll();	
		}
	   
		q.clear();
		
		if (node.right != null) {
			findDeepestLeave(node.right);
			 max+=q.poll();	
		}
		
		return max;
		
	}
	public void findDeepestLeave(Node node) {
		if (node == null) {
			return ;
		}
		findDeepestLeave(node.left);
		findDeepestLeave(node.right);
		q.add(node.value);
		
		
		
		
		
	}
	
	public static void main(String args[]) {
		
		Tree tree = new Tree();
        Tree.Node node = tree.new Node(1);
        node.left = tree.new Node(2); 
        node.right = tree.new Node(3); 
        node.left.left = tree.new Node(4); 
        node.left.right = tree.new Node(5); 
        node.left.left.left = tree.new Node(7); 
        node.right.right=tree.new Node(6);
        node.right.right.right = tree.new Node(8);
        System.out.println(new DeepestLeaveSum().maxSum(node));
       
        
	}
	
	
}
