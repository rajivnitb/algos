package com.algo.dp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/longest-arithmetic-progression/
 * @author RajivDevaraj
 *
 */
public class LongestArithProgression {

	public int getLongestValue(int[] a, int index) {
		Map<Integer, Integer> map = findLongest(a, index, new HashMap<Integer, Integer>());
		if (!map.isEmpty()) {
			Collections.max(map.values());
			if (map.values().iterator().next() != 0) {
				return map.values().iterator().next() + 1;
			} else {
				return map.values().iterator().next();
			}
		}else {
			return 0;
		}

	}

	public Map<Integer, Integer> findLongest(int[] a, int index, Map<Integer, Integer> map) {
		if (a.length - 1 < index) {
			return map;
		}

		findLongest(a, index + 1, map);
		if (index < a.length - 1) {
			for (int i = a.length - 1; i >= index; i--) {
				if (i != index) {
					if (map.containsKey(a[i] - a[index])) {
						map.put(a[i] - a[index], map.get(a[i] - a[index]) + 1);
					} else {
						map.put(a[i] - a[index], 1);
					}
				}
			}
		}
		return map;
	}

	public static void main(String args[]) {
		int[] a = { 9, 4, 7, 2, 10 };
		// int [] a = {3, 6, 9, 12};
		System.out.println(new LongestArithProgression().getLongestValue(a, 0));
	}
}
