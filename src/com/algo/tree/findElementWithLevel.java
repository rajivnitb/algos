package com.algo.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.algo.tree.SortArrayToBST.Node;

public class findElementWithLevel {

	Node root;

	public class Node {
		Node left = null;
		Node right = null;
		int value;

		public Node(int value) {
			this.left = null;
			this.right = null;
			this.value = value;
		}
	}

	Node add(Node node, int value) {

		if (node == null) {
			node = new Node(value);
			return node;
		}

		if (value < node.value)
			node.left = add(node.left, value);
		else if (value > node.value)
			node.right = add(node.right, value);
		return node;
	}

	void findElement(Node node, int i, int depth) {
		if (node.value == i) {
			System.out.println(depth);
			return;
		}

		if (node.value < i) {
			if (node.right != null && node.right.value == i) {
				System.out.println(depth+1);
				return;
			} else {
				findElement(node.right, i, depth + 1);
			}

		} else {
			if (node.left != null && node.left.value == i) {
				System.out.println(depth + 1);
				return;
			} else {
				findElement(node.left, i, depth + 1);
			}
		}
	}

	Map<Integer, Integer> findAllElementsByDepth(Node node, List<Integer> list, Map<Integer, Integer> map, int depth) {
		if (node == null || list.isEmpty()) {
			return map;
		}

		map.put(node.value, depth);
		list.remove(Integer.valueOf(node.value));
		findAllElementsByDepth(node.left, list, map, depth + 1);
		findAllElementsByDepth(node.right, list, map, depth + 1);

		return map;

	}

	public static void main(String args[]) {
		LinkedList <Integer>list = new LinkedList<Integer>(){{
			add(4);
			add(3);
			add(2);
			add(1);
			add(7);
			add(6);
			add(5);
		}}; 
		
		findElementWithLevel tree = new findElementWithLevel();
		for (Integer i : list) {
			tree.root = tree.add(tree.root,i);
		}
        /** find element's depth **/
		tree.findElement(tree.root,7, 0);
	    
		/** find all elements depth **/
		Map<Integer, Integer> map = tree.findAllElementsByDepth(tree.root, list, new HashMap<Integer, Integer>(), 0);
		for (Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + "**" + e.getValue());
		}

	}

}
