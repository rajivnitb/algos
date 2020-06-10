package com.algo.tree;

import java.util.ArrayList;
import java.util.List;

import com.algo.tree.Tree.Node;

/**
 * https://www.interviewbit.com/problems/2sum-binary-tree/
 * @author RajivDevaraj
 *
 */
public class TwoSumBT {
	
	public List<Node> getNodeOfSum(Node node,int i,List<Node> list,Node orgNode){
		if (node == null) {
			return null;
		}
		Node nodex=findElement(orgNode,Math.abs(i-node.value));
		if (nodex != null) {

			int sum = node.value + nodex.value;
			if (sum == i) {
				
				list.add(node);
				list.add(nodex);
				return list;
			}
		}
		getNodeOfSum(node.left,i,list,orgNode);
		getNodeOfSum(node.right,i,list,orgNode);
		
		return list;
	}
	
	
  public Node findElement(Node node,int k) {
		if  (node == null) {
			return node ;
		}
		if (node.value == k) {
			return node;
		}
		if (node.value >= k) {
		    return findElement(node.left,k);
		}
		else if (node.value <= k) {
		    return findElement(node.right,k);
		}
		return node;
	}

	public static void main(String argsp[]) {
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(10);
		node.left = tree.new Node(10);
		node.right = tree.new Node(20);
		node.left.left = tree.new Node(8);
		node.left.right = tree.new Node(12);
		node.right.left = tree.new Node(25);
		node.right.right = tree.new Node(16);	
		
		List<Node> nodeList=new TwoSumBT().getNodeOfSum(node,28,new ArrayList<Node>(),node);
		for (Node nodes : nodeList) {
			System.out.println(nodes.value);
		}
	}
}
