package com.algo.tree;

import java.util.ArrayList;
import java.util.List;

import com.algo.tree.Tree.Node;

/**
 * https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 * 
 * @author RajivDevaraj
 *
 */
public class RootSum {

	static List<String> list = new ArrayList<String>();

	public List<String> getSum(Tree.Node node, String s) {

		if (node == null) {
			return list;
		}

		if (node != null && node.left != null) {
			getSum(node.left, s + String.valueOf(node.left.value));
		} else {
			if (node.left == null && node.right == null) {
				list.add(s);
				return list;
			}
			
			
		}
		if (node != null && node.right != null) {
			getSum(node.right, s + String.valueOf(node.right.value));
		} else {
			list.add(s);
			return list;
		}

		return list;

	}

	public static void main(String args[]) {
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(6);
		node.left = tree.new Node(3);
		node.right = tree.new Node(5);
		node.left.left = tree.new Node(2);
		node.left.right = tree.new Node(5);
		node.left.right.left = tree.new Node(7);
		node.left.right.right = tree.new Node(4);
		node.right.right = tree.new Node(4);
		new RootSum().getSum(node, new String(String.valueOf(node.value)));
		System.out.println(list);
		// System.out.println(sumFinal);

	}
}
