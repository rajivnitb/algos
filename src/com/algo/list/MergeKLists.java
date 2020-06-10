package com.algo.list;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergeKLists {

	public List mergeKLists(List[] lists, List newList, CopyOnWriteArrayList<Integer> javaList) {
		int counter = 0;
		int leastValue = 0;
		List[] temp = new List[lists.length];
		if (isListPresent(lists) && javaList.isEmpty()) {
			return newList;
		}
		if (!javaList.isEmpty()) {
			leastValue=javaList.get(0);
		}
		
		int index = 0;
		for (List list : lists) {
			if (counter == 0) {
				if (list != null && list.head != null) {
				leastValue = list.head.value;
				leastValue = Math.min(leastValue, leastValue);
				counter++;
				}
			} else {
				if (list != null && list.head != null) {

					leastValue = Math.min(leastValue, list.head.value);
				}
			}

			if (list != null && list.head != null) {
				javaList.add(list.pop());
				if (list != null && list.head != null) {
				temp[index] = list;
				index++;
				}
			}
		}

		for (Integer i : javaList) {
			leastValue = Math.min(leastValue, i);
		}

		for (Integer listValue : javaList) {
			if (leastValue == listValue) {
				newList.add(listValue);
				javaList.remove(listValue);
			}
		}

		Collections.sort(javaList);
		return mergeKLists(temp, newList, javaList);
	}

	private boolean isListPresent(List[] lists) {
		boolean flag = false;
		for (List list : lists) {
			if (list == null || list.head == null) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static void main(String args[]) {

		List ls1 = new List();
		ls1.add(1);
		ls1.add(4);
		ls1.add(5);

		List ls2 = new List();
		ls2.add(1);
		ls2.add(3);
		ls2.add(4);

		List ls3 = new List();
		ls3.add(2);
		ls3.add(6);

		List[] lists = { ls1, ls2, ls3 };
		CopyOnWriteArrayList<Integer> cpyList = new CopyOnWriteArrayList<Integer>();
		List finalList = new MergeKLists().mergeKLists(lists, new List(), cpyList);
		finalList.printLinkedList(finalList.head);

	}
}
