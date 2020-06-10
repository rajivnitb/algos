package com.algo.list;

import java.util.Stack;

public class AddTwoNum {

	private Node head;
	private Node tail;

	class Node {

		int value;
		Node next;

		public Node(int value) {
			this.next = null;
			this.value = value;
		}

	}

	public void add(int value) {

		Node node = new Node(value);

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public void printLinkedList(Node node) {
		Node current = node;
		while (current != null) {
			System.out.print(current.value+" -->");
			
			current = current.next;
		}
		System.out.print("null");
	}

	int reverseList(Stack<Integer> stack) {

		StringBuilder sb = new StringBuilder();
		while (!stack.empty()) {
			sb.append(stack.pop());
		}

		return Integer.valueOf(sb.toString());

	}

	public static void main(String args[]) {

		Stack<Integer> st1 = new Stack<Integer>();
		st1.add(2);
		st1.add(4);
		st1.add(3);

		Stack<Integer> st2 = new Stack<Integer>();
		st2.add(5);
		st2.add(6);
		st2.add(4);

		AddTwoNum twoNum = new AddTwoNum();

		int finalSum = twoNum.reverseList(st1) + twoNum.reverseList(st2);

		String temp = Integer.toString(finalSum);
		Node node = null;
		for (int i = temp.length() - 1; i >= 0; i--) {
			twoNum.add(Character.getNumericValue(temp.charAt(i)));
		}

		twoNum.printLinkedList(twoNum.head);

	}

}
