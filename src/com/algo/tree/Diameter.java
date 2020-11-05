package com.algo.tree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * @author Rajiv Devaraj
 *
 */
public class Diameter {
	Integer max =Integer.MIN_VALUE;
	
	
	public int getMXDIA(Tree.Node node) {
		if (node == null) {
			return 0;
		}
	    return getMxLen(node.left,0)+getMxLen(node.right,0)+1;	
	}
	
	public int getMxLen(Tree.Node node,int count) {
		
		if (node == null) {
			
			return count ;
		}
		
		
		getMxLen(node.left, count+1);
		getMxLen(node.right, count+1);
		max= Math.max(max,count);
		return max;
	}
	
	
	public static void main(String args[]) {
		Tree tree = new Tree();
        Tree.Node node = tree.new Node(1);
        node.left = tree.new Node(2); 
        node.right = tree.new Node(3); 
        node.left.left = tree.new Node(4); 
        node.left.right = tree.new Node(5); 
        System.out.println(new Diameter().getMXDIA(node));
	}

}
