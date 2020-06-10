package com.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/flip-array/
 * 
 * @author RajivDevaraj
 *
 */
public class FlipArray {

	Map<Integer, Integer> map = new HashMap<>();

	public int getMinSum(int[] a, int index, int sum, int steps) {

		int negSum;
		int posSum;
		if (index > a.length - 1) {
			if (sum >= 0) {
				if (map.isEmpty()) {
					map.put(sum, steps);
				} else {
					if (sum <= map.keySet().iterator().next()) {
						if (sum == map.keySet().iterator().next()) {
							if (map.values().iterator().next() > steps) {
								map.put(sum, steps);
								System.out.println(sum + "==>" + steps);
							}

						} else {
							map.clear();
							map.put(sum, steps);
							System.out.println(sum + "==>" + steps);
						}
					}
				}
			}
			return map.values().iterator().next();
		} else {
			posSum = sum + a[index];
			negSum = sum - a[index];
		}

		getMinSum(a, index + 1, posSum, steps);
		getMinSum(a, index + 1, negSum, steps + 1);

		return map.values().iterator().next();

	}

	public static void main(String args[]) {
		int[] a = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(new FlipArray().getMinSum(a, 0, 0, 0));

	}
}
