package com.algo.tree;

import java.util.Stack;

import com.algo.tree.Tree.Node;

public class PostOrderBT {

	public void getInPostOrder(Node node) throws CloneNotSupportedException {
		Stack<Node> stack = new Stack();
		Node tmpNode1= (Node) node.clone();
		tmpNode1.left=null;
		tmpNode1.right=null;
		stack.add(tmpNode1);
		if (node.right != null) {
			stack.push(node.right);
		}
		if (node.left != null) {
			stack.push(node.left);
		}	
		
		while (!stack.isEmpty()) {
			Node tmp = (Node) stack.peek().clone();
			if (tmp.left != null || tmp.right != null) {
				Node finalNode=stack.pop();
				finalNode.left=null;
				finalNode.right=null;
				stack.add(finalNode);
				if (tmp.right != null) {
					stack.add(tmp.right);
				}
				if (tmp.left != null) {
					stack.add(tmp.left);
				}
			
				
			} else {
				System.out.print(stack.pop().value+" ");
			}

		}

	}



	public static void main(String args[]) throws CloneNotSupportedException {
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(1);
		node.left = tree.new Node(2);
		node.right = tree.new Node(3);
		node.left.left = tree.new Node(4);
		node.left.right = tree.new Node(5);
		node.right.left = tree.new Node(6);
		node.right.right = tree.new Node(7);
		new PostOrderBT().getInPostOrder(node);

	}
}
