package com.algo.tree;

import java.util.ArrayList;
import java.util.List;


import com.algo.tree.Tree.Node;

/**
 * https://www.interviewbit.com/problems/cousins-in-binary-tree/
 * @author Rajiv Devaraj
 *
 */
public class CousinsInBT {

	static List<Integer> list = new ArrayList<>();
 
	static CousinsInBT.NodeDetail nodeDetail = new CousinsInBT.NodeDetail() ;

	// class to store the level in which the node was found
	static class NodeDetail{
		int level ;
		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		Node parentNode ;
		
		public Node getParentNode() {
			return parentNode;
		}

		public void setParentNode(Node parentNode) {
			this.parentNode = parentNode;
		}

	
	}
	
	/**
	 * method to identify the node located level
	 * @param node
	 * @param value
	 * @param level
	 * @param parentNode
	 * @return
	 */
	NodeDetail findLevelOfNode(Tree.Node node,int value,int level,Node parentNode) {
    	if (node == null ) {
    		return null ;
    	}
    	if (node.value == value) {
    		
    		nodeDetail.setLevel(level);
    		nodeDetail.setParentNode(parentNode);
    		return  nodeDetail;
    	}
    	
    	findLevelOfNode(node.left,value,level+1,node);
    	findLevelOfNode(node.right,value,level+1,node);
    	
    	return nodeDetail ;
    	
    }
	
	/**
	 * Find it's cousins
	 * @param node
	 * @param value
	 * @param parentNode
	 * @param level
	 */
	void findCousins(Tree.Node node, int value, Node parentNode, int level) {

		if (node == null) {
			return;
		}

		if (parentNode.value == nodeDetail.getParentNode().value) {
			return;
		}

		if (level == nodeDetail.getLevel()) {
			list.add(node.value);
		}

		findCousins(node.left, value,node,level+1);
		findCousins(node.right, value, node,level+1);

	}
	
	public static void main(String args[]) {
		Tree tree = new Tree();
        Tree.Node node = tree.new Node(1);
        node.left = tree.new Node(2); 
        node.right = tree.new Node(3); 
        node.left.left = tree.new Node(4); 
        node.left.right = tree.new Node(5); 
        node.right.left=tree.new Node(6);
        node.right.right=tree.new Node(7);
        CousinsInBT cBT = new CousinsInBT();
        cBT.findLevelOfNode(node, 5, 0, null);
        cBT.findCousins(node, 5,node,0);
        list.stream().forEach(System.out::println);
	}
}
