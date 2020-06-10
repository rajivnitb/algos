package com.algo.tree;

import java.util.HashMap;
import java.util.Map;

import com.algo.tree.Tree.Node;

public class NXTPointerTree {
	
	public void createRef(Tree tree) {
		traverseNode(tree,tree.root,0,new HashMap<Integer,Node>());
	}

	public Map<Integer,Node> traverseNode(Tree tree,Node node,int counter,Map <Integer,Node> map) {
		
		if(node ==null ) {
			return map ;
		}
		counter ++ ;
		
		
		traverseNode(tree,node.left,counter,map);
		buildReference(map,node.left,counter);
		traverseNode(tree,node.right,counter,map);
		buildReference(map,node.right,counter);
		return map;
		
	}
	
	public void buildReference(Map<Integer,Node> map,Node node,int counter) {
		if (node == null) {
			return ;
		}
		if (map.isEmpty()) {
			map.put(counter,node);
			
		}
		else {
			if(!map.containsKey(counter)) {
				map.put(counter,node);
			}
			else {
				if(map.get(counter) != null) {
			    	Node tmpNode=map.get(counter);
			    	tmpNode.map(tmpNode, node);
			      	map.put(counter,tmpNode);
				}
			}
		}
		
	}
	
	public static void main(String args[]) {
		
		 Tree tree = new Tree();
         tree.root  = tree.new Node(1);
         tree.root.left = tree.new Node(2); 
         tree.root.right = tree.new Node(5); 
         tree.root.left.left = tree.new Node(3); 
         tree.root.left.right = tree.new Node(4); 
         tree.root.right.left = tree.new Node(6); 
         tree.root.right.right = tree.new Node(7);
         NXTPointerTree nxt = new NXTPointerTree();
         nxt.createRef(tree);
         System.out.println(tree.root);
	}
	
}

