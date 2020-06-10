package com.algo.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class LRUCache {

	DLLNode head = null;
	DLLNode tail ;
	DLLNode tmpTailPrev;
	DLLNode tmpNode ;
	Map <Integer,DLLNode> map = new HashMap<Integer,DLLNode>();
	static LRUCache instance = null;
	int capacity ;
	Integer firstKey;
	
	
	private static LRUCache getInstance() {
		if (instance == null) {
			instance=new LRUCache();
		}
		return instance;
	}

	class DLLNode {

		int value;
		int key;
		DLLNode prev;
		DLLNode next;

		public DLLNode(int key, int value) {

			this.key = key;
			this.value = value;
			this.next = head;
			this.prev = null;
			if (head != null) {
				head.prev = this;
			}
			head = this;

		}

	}
	
	
	public void update(DLLNode dllNode) {
		deleteNode(dllNode);
	}
	
	void deleteNode(DLLNode del) 
    { 
        if (head == null || del == null) 
            return ; 
  
        if (head == del) 
            head = del.next; 
  
        if (del.next != null) 
            del.next.prev = del.prev; 
  
        if (del.prev != null) 
            del.prev.next = del.next; 
  
        del = null; 
  
        
    } 

	public void get(int key) {
       System.out.println("Element Value for key "+key+" : "+map.get(key).value);
       DLLNode tmpNode=map.get(key);
       update(tmpNode);
       map.remove(key);
       put(key,tmpNode.value);
       
	}

	public void put(int key,int value) {
		if (map.size() <= capacity) {
			if (map.containsKey(key)) {
				update(map.get(key));
				map.put(key, getInstance().new DLLNode(key, value));
			}
			else {
				map.put(key, getInstance().new DLLNode(key, value));
			}
			 
		}else {
			 if (!map.containsKey(key)) {
			  // remove(map.get(key));
			   map.put(key,getInstance().new DLLNode(key,value)); 
			 }else {
				  DLLNode tempNode=map.get(key);
				  update(tempNode);
				  //tempNode.value=value;
				  map.put(key,getInstance().new DLLNode(key, value));
			 }
		}
       
		
		
	}

	public static void main(String args[]) {

		getInstance().capacity=3;
		getInstance().put(1, 1);
		getInstance().put(2,2);
		getInstance().put(3, 3);
		getInstance().put(4, 4);
		getInstance().put(5, 5);
		getInstance().put(3, 7);
		
		
		getInstance().get(4);
		DLLNode node =getInstance().head;
		while(node !=null) {
			System.out.print(node.value+" ");
			node=node.next;
		}
		
	}
}
