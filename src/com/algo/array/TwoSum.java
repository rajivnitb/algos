package com.algo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public class Node {

		int index;
		int value;

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int hashCode() {
			return index;

		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;

			if (obj == null || obj.getClass() != this.getClass())
				return false;

			Node node = (Node) obj;

			return node.index == this.index;
		}

	}

	ArrayList<Integer> findIndices(int[] a, int target) {
		Map<Integer, Node> totalmap = new HashMap<Integer, Node>();
		for (int i = 0; i < a.length - 1; i++) {
			if (!totalmap.containsKey(a[i])) {
				if (a[i] >= target) {
					totalmap.put(a[i] - target, new Node(i, a[i]));
				} else if (a[i] < target) {
					totalmap.put(target - a[i], new Node(i, a[i]));
				}
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				list.add(totalmap.get(a[i]).getIndex());

				return list;
			}

		}
		return null;
	}

	public static void main(String args[]) {
		int[] a = {2, 7, 11, 15};
		System.out.println(new TwoSum().findIndices(a,9));

	}

}
