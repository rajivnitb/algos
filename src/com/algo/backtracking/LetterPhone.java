package com.algo.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/letter-phone/
 * @author RajivDevaraj
 *
 */
public class LetterPhone {

	static Map<Integer, String> map = new HashMap<Integer, String>();
	static ArrayList<String> list = new ArrayList<String>();

	public ArrayList<String> letterCombinations(int[] a, String current, int index) {

		if (index > a.length - 1) {
			list.add(current);
			return list;
		}

		String s = map.get(a[index]);
		for (int i = 0; i <= s.length() - 1; i++) {
			if (current == null) {
				current = new String();
			}
			current += s.charAt(i);
			letterCombinations(a, current, index + 1);
            current=current.substring(0,index) ;
           
		}

		return list;

	}

	public static void main(String args[]) {

		map.put(1, null);
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		int[] a = new int[] { 2, 3, 4 };
		new LetterPhone().letterCombinations(a,null, 0);
		System.out.println(list);
	}
}
