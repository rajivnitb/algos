package com.algo.tree;

import java.util.Map;

public class SortArrayToBST {
	static Node root ;
	public class Node{
		
		Node left ; 
		Node right ;
		int value ;
		
		public Node(int value) {
			this.value = value ;
			this.left = null ;
			this.right = null ;
		}
	}

	public Node constructToBST(int []a,int start,int end) {
		if (start > end) {
			return null;
		}
		
		int mid=(start+end)/2;
		Node node = new Node(a[mid]);
		node.left= constructToBST(a,start,mid-1);
	    node.right =constructToBST(a,mid+1,end);
	    
	    return node;
	}
	
	void preOrder(Node node) { 
        if (node == null) { 
            return; 
        } 
        System.out.print(node.value + " "); 
        preOrder(node.left); 
        preOrder(node.right); 
    } 
	
	int findElement(Node node,int i,int depth) {
	 	while(node !=null) {
	 		if (node.value == i) {
	 			return depth ;
	 		}
	 		
	 		if (node.value < i) {
	 			if (node.right !=null && node.right.value == i ) {
	 				return depth +1 ;
	 			}
	 			else {
	 				if (node.right == null) {
	 					return -1 ;
	 				}
	 				findElement(node.right, i, depth+1);
	 			}
	 			
	 		}
	 		else {
	 			if (node.left !=null && node.left.value == i ) {
	 				return depth +1 ;
	 			}
	 			else {
	 				if (node.left !=null) {
	 					return -1;
	 				}
	 				findElement(node.left, i, depth+1);
	 			}
	 		}
	 	}
		return -1;
	}
	
	
	
	public static void main(String args[]) {
		int a[] = {1,2,3,4,5,6,7};
		SortArrayToBST sortedArtoBST = new SortArrayToBST();
		sortedArtoBST.root =sortedArtoBST.constructToBST(a,0,a.length-1);
		//sortedArtoBST.preOrder(sortedArtoBST.root);
		System.out.println(sortedArtoBST.findElement(sortedArtoBST.root,5,0));
	}
}
