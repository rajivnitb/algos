package com.algo.list;

import com.algo.list.AddTwoNum.Node;

public class List {

	public Node head;
	public Node tail;
	
	public class Node
	{
		
		Node next = null ;
		int value ;
		
		public Node(int value) {
			this.next=null;
			this.value=value;
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
	
	public int pop()
	{
		int temp = head.value;
		head=head.next;
		return temp ;
	}

public static void main(String args[]) {
		
		List ls1 = new List();
		ls1.add(1);
		ls1.add(4);
		ls1.add(5);
		
		ls1.pop();
		
		ls1.printLinkedList(ls1.head);
		
}
}
