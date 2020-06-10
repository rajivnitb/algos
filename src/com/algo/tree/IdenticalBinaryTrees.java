package com.algo.tree;

import java.util.Stack;

import com.algo.tree.Tree.Node;

public class IdenticalBinaryTrees {

	public boolean isIdentical(Node node1, Node node2) {
		Stack<Node> nodeStack1 = new Stack<>();
		Stack<Node> nodeStack2 = new Stack<>();
		boolean flag = true;
		nodeStack1.add(node1);
		nodeStack2.add(node2);
		while (true) {
			if (nodeStack1.size() ==0 && nodeStack2.size() == 0) {
				return true;
			}
			if (nodeStack1.peek().value == nodeStack2.peek().value) {
				Node node1Tmp = nodeStack1.pop();
				Node node2Tmp = nodeStack2.pop();
                System.out.println(node1Tmp.value);
                System.out.println(node2Tmp.value);
                if(node1Tmp.left != null && node2Tmp.left != null) {
                	 if  (node1Tmp.left.value == node2Tmp.left.value) {
						nodeStack1.add(node1Tmp.left);
						nodeStack2.add(node2Tmp.left);
                	 }else {
                		flag = false;
 						break;
                	 }
				} else {
					   boolean node1Flag=false,node2Flag=false;
					   if (node1Tmp.left == null) {
						   node1Flag=true;
					   }
					   if (node2Tmp.left == null) {
						   node2Flag=true;
					   }
					   if (!(node1Flag=node2Flag)) {
						flag = false;
						break;
					   }
				}
				if (node1Tmp.right != null && node2Tmp.right != null) {
					if (node1Tmp.right.value == node2Tmp.right.value) {
						nodeStack1.add(node1Tmp.right);
						nodeStack2.add(node2Tmp.right);
					}else {
						flag = false;
 						break;
					}
				} else {
					boolean node1Flag=false,node2Flag=false;
					   if (node1Tmp.right == null) {
						   node1Flag=true;
					   }
					   if (node2Tmp.right == null) {
						   node2Flag=true;
					   }
					   if (!(node1Flag=node2Flag)) {
						flag = false;
						break;
					   }

				}

			}

		}
		return flag;

	}

	public static void main(String args[]) {
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(1);
		node.left = tree.new Node(2);
		node.right = tree.new Node(2);
		node.left.left = tree.new Node(3);
		node.left.right = tree.new Node(4);
		node.right.left = tree.new Node(4);
		node.right.right = tree.new Node(3);

		Tree.Node node1 = tree.new Node(1);
		node1.left = tree.new Node(2);
		node1.right = tree.new Node(2);
		node1.left.left = tree.new Node(3);
		node1.left.right = tree.new Node(4);
		node1.right.left = tree.new Node(4);
		node1.right.right = tree.new Node(3);

		System.out.println(new IdenticalBinaryTrees().isIdentical(node, node1));
	}
}
