package com.algo.tree;

import com.algo.tree.Tree.Node;

public class ValidBST {

        boolean  isValidBST(Node node,Node parent,boolean isLeft,boolean isRoot) {
			if (node == null) {
				return true;
			}
			if (!isRoot) {
				if (isLeft) {
					if (node.value > parent.value) {
						return false;
					}
				} else {
					if (node.value < parent.value) {
						return false;
					}
				}
			}
    	
    	  return isValidBST(node.left,node,true,false) && isValidBST(node.right,node,false,false);
    	
    	
    	
    }
	
	public static void main(String args[]) {
		
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(10);
        node.left = tree.new Node(4); 
        node.right = tree.new Node(15); 
        node.left.left = tree.new Node(3); 
        node.left.right = tree.new Node(9); 
        node.right.left=tree.new Node(11);
        node.right.right=tree.new Node(16);
        System.out.println(new ValidBST().isValidBST(node,node,false,true));
        
        
		
	}
}
