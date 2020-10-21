package com.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/subset/
 * @author RajivDevaraj
 *
 */
public class SubSet {

	static List<Integer> ls = new ArrayList<Integer>();

	public void subsets(int[] a, int index, int nextIndex) {

		if (nextIndex == a.length && index <= a.length) {
			subsets(a, index + 1, index + 1);
		}

		if (nextIndex > a.length - 1 || index > a.length - 1) {
			return;
		}

		if (index == nextIndex) {
			ls.add(a[index]);
		}

		if (index != nextIndex) {
			String s = new String();
			s = String.valueOf(ls.get(ls.size() - 1)) + String.valueOf(a[nextIndex]);
			ls.add(Integer.valueOf(s));
		}

		subsets(a, index, nextIndex + 1);
		
	}

	public static void main(String args[]) {
		new SubSet().subsets(new int[] { 1, 2, 3 }, 0, 0);
		System.out.println(ls);
	}
}
