package com.algo.tree;

import com.algo.tree.Tree.Node;

/**
 * https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
 * @author RajivDevaraj
 *
 */
public class DistanaceBT {

	boolean iflag = true;
	boolean jflag = true;
	int iCount = -1;
	int jCount = -1;

	public int getDist(Node node, int i, int j) {
		findDist(node, i, j, 0);
		if (iCount >= 0 && jCount >= 0)
			return iCount > jCount ? iCount : jCount;
		else
			return -1;
	}

	public int findDist(Node node, int i, int j, int count) {

		if (node == null) {
			count = 0;
			return -1;
		}

		if (node.value == i && iflag) {
			iCount = count + 1;
			iflag = false;
			if (jflag) {
				findDist(node.left, i, j, 0);
				findDist(node.right, i, j, 0);
			}
		}

		if (node.value == j && jflag) {
			jflag = false;
			jCount = count + 1;
			if (iflag) {
				findDist(node.left, i, j, 0);
				findDist(node.right, i, j, 0);
			}
		}

		findDist(node.left, i, j, count + 1);
		findDist(node.right, i, j, count + 1);

		if (!iflag && !jflag) {
			return count;
		} else {
			return -1;
		}

	}

	public static void main(String args[]) {
		Tree tree = new Tree();
		Tree.Node node = tree.new Node(1);
		node.left = tree.new Node(2);
		node.right = tree.new Node(3);
		node.left.left = tree.new Node(4);
		node.left.right = tree.new Node(5);
		node.right.left = tree.new Node(6);
		node.right.right = tree.new Node(7);
		node.right.right.right = tree.new Node(8);
		node.right.right.right.right = tree.new Node(9);
		node.right.right.right.right.right = tree.new Node(10);
		System.out.println(new DistanaceBT().getDist(node, 1, 11));
	}
}
