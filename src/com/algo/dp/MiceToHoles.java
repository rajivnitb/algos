package com.algo.dp;

/** Amazon asked **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class MiceToHoles {

	Stack<Map<Integer, MiceHoleRS>> stack = new Stack<Map<Integer, MiceHoleRS>>();

	public class IndexRs implements Comparable<IndexRs> {

		Integer diffIndexFromHole;
		Integer holeIndex;

		public IndexRs(Integer diffIndexFromHole, Integer holeIndex) {
			this.diffIndexFromHole = diffIndexFromHole;
			this.holeIndex = holeIndex;
		}

		@Override
		public int compareTo(IndexRs indexRS) {
			if (diffIndexFromHole == indexRS.diffIndexFromHole)
				return 0;
			else if (diffIndexFromHole > indexRS.diffIndexFromHole)
				return 1;
			else
				return -1;
		}
	}

	public class MiceHoleRS {

		Integer Left;
		Integer middle;
		Integer right;

		public MiceHoleRS(Integer left, Integer middle, Integer right) {
			this.Left = left;
			this.right = right;
			this.middle = middle;
		}
	}

	public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {

		storeMyNeigbhourHoles(A, B);
		int hole = 0;
		return evaluate(A, B, hole);

	}

	private int evaluate(ArrayList<Integer> A, ArrayList<Integer> B, int hole) {

		if (stack.isEmpty() || B.isEmpty()) {
			return hole;
		}
		int counter = 0;
		Map<Integer, MiceHoleRS> map = stack.pop();
		Map<Integer, MiceHoleRS> nextMap = null;
		if (!stack.isEmpty()) {
			nextMap = stack.peek();
		}
		List<IndexRs> currentList = computeDiff(map);
		List<IndexRs> nextList = null;
		if (nextMap != null) {
			nextList = computeDiff(nextMap);
		}
		for (IndexRs indexrs : currentList) {
			if (B.contains(indexrs.holeIndex)) {

				break;
			}
			counter++;
		}
		if (nextList != null) {
			
			if (currentList.get(counter).holeIndex != nextList.get(counter).holeIndex) {
				if (hole > currentList.get(counter).holeIndex) {
					hole = Math.max(hole, currentList.get(counter).diffIndexFromHole);

				} else {
					hole = currentList.get(counter).diffIndexFromHole;
				}
				B.remove(currentList.get(counter).holeIndex);

			} else {
				if (hole > currentList.get(counter + 1).holeIndex) {
					hole = Math.max(hole, currentList.get(counter + 1).diffIndexFromHole);
				} else {
					hole = currentList.get(counter + 1).diffIndexFromHole;
				}
				B.remove(currentList.get(counter + 1).holeIndex);
			}
		} else {
			hole = Math.max(hole, currentList.get(counter).diffIndexFromHole);
			B.remove(currentList.get(counter).holeIndex);
		}

		return evaluate(A, B, hole);
	}

	List<IndexRs> computeDiff(Map<Integer, MiceHoleRS> map) {
		Integer currentIndex = null;
		MiceHoleRS currentIndexRs = null;
		Integer leftIndex = null;
		Integer rightIndex = null;
		Integer middleIndex = null;
		List<IndexRs> list = new ArrayList<IndexRs>();
		for (Entry<Integer, MiceHoleRS> entry : map.entrySet()) {
			currentIndex = entry.getKey();
			currentIndexRs = entry.getValue();
		}
		List<Integer> ls = new ArrayList<Integer>();
		if (currentIndexRs.Left != null) {
			leftIndex = Math.abs(currentIndex - currentIndexRs.Left);
			IndexRs indexLeft = new IndexRs(leftIndex, currentIndexRs.Left);
			list.add(indexLeft);
		}
		if (currentIndexRs.right != null) {
			rightIndex = Math.abs(currentIndex - currentIndexRs.right);
			IndexRs indexRight = new IndexRs(rightIndex, currentIndexRs.right);
			list.add(indexRight);
		}
		if (currentIndexRs.middle != null) {
			middleIndex = Math.abs(currentIndex - currentIndexRs.middle);
			IndexRs indexMiddle = new IndexRs(middleIndex, currentIndexRs.middle);
			list.add(indexMiddle);
		}

		Collections.sort(list);
		return list;

	}

	void storeMyNeigbhourHoles(ArrayList<Integer> A, ArrayList<Integer> B) {
		Integer mouseIndex = null;
		Integer left = null;
		Integer right = null;
		Integer middle = null;
		for (int i = 0; i <= A.size() - 1; i++) {
			Map<Integer, MiceHoleRS> map = new HashMap<>();
			mouseIndex = A.get(i);
			if (i > 0) {
				left = B.get(i - 1);
			} else {
				left = null;
			}
			if (i + 1 <= B.size() - 1) {
				right = B.get(i + 1);
			} else {
				right = null;
			}
			middle = B.get(i);
			map.put(mouseIndex, new MiceHoleRS(left, middle, right));
			stack.add(map);
		}
	}

	public static void main(String args[]) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();

		/*
		 * A.add(4); A.add(-4); A.add(2);
		 * 
		 * B.add(4); B.add(0); B.add(5);
		 */

		/*
		 * A.add(4); A.add(-4); A.add(2);
		 * 
		 * B.add(1); B.add(5); B.add(0);
		 */
		
		Integer []a = {33, -81, -13, -14, -36, -69, -94, -1, -95, -4, 98, -23, 82, 66, 37, -44, -97, -28, -58};
        Integer []b = {98, -5, -32, -76, 99, 100, 13, 58, -9, -69, 31, 63, 66, -53, -22, -13, 2, 32, 91};
        
		Collections.addAll(A,a);
        Collections.addAll(B,b);
        
        System.out.println(new MiceToHoles().mice(A, B));

	}
}
