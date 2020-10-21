package com.algo.queus;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;



/**
 * https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/
 * @author RajivDevaraj
 *
 */
public class StreamTracking {

	public static String trackedString;
	public static int index = 0;
	public static int refChar = 0;
	public Set<String> set = new HashSet<String>();
	public Stack<String> stack = new Stack<>();
	public String tmpJoinStr = null;


	private String solveStreamTrack(String str, int index, int orgLen) {

		if (index >= orgLen) {
			return trackedString;
		}

		if (set.isEmpty()) {
			set.add(String.valueOf(str.charAt(0)));
			stack.add(String.valueOf(str.charAt(0)));
			trackedString = String.valueOf(str.charAt(0));
		} else {

			if (!trackedString.substring(trackedString.length() - 1).equals(String.valueOf(str.charAt(0)))
					&& set.contains(trackedString.substring(trackedString.length() - 1))) {
				trackedString += trackedString.substring(trackedString.length() - 1);
				stack.add(String.valueOf(str.charAt(0)));

			} else {
				tmpJoinStr = stack.pop();
				if (tmpJoinStr.equals(String.valueOf(str.charAt(0)))) {
					tmpJoinStr = stack.pop();
					trackedString += tmpJoinStr;
					stack.add(String.valueOf(str.charAt(0)));
					stack.add(tmpJoinStr);
				} else {
					trackedString += tmpJoinStr;
					stack.add(String.valueOf(str.charAt(0)));
					stack.add(tmpJoinStr);
				}

			}

		}

		solveStreamTrack(str.substring(1, str.length()), index + 1, orgLen);
		System.out.println(trackedString);
		return trackedString;
	}

	public static void main(String args[]) {
		String str = "abadbc";
		System.out.println(new StreamTracking().solveStreamTrack(str, 0, str.length()));
	}
}
