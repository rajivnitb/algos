package com.algo.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class FlipBT {
	
	public class RelationShip {

		Tree.Node leftChild ;
		
		Tree.Node rightChild ;
		
		public Tree.Node getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Tree.Node leftChild) {
			this.leftChild = leftChild;
		}

		public Tree.Node getRightChild() {
			return rightChild;
		}

		public void setRightChild(Tree.Node rightChild) {
			this.rightChild = rightChild;
		}
		
	}

	private Tree tree = null ;
	
	public FlipBT() {
		 tree = new Tree();
	}
	
	public Map <Tree.Node,RelationShip> insertedNode = new HashMap<Tree.Node,RelationShip>();
		
	public Tree.Node Flip(Tree.Node node,Stack <Tree.Node> stack){
	   Tree.Node tmpNode = node;
	   Tree.Node tmpRightNode=node.right;
		
	   stack.add(tmpNode);
	   while (tmpNode.left != null) {
			stack.add(tmpNode.left);
			tmpNode=tmpNode.left;
		}
		Tree.Node newNode=null;
		newNode=constructLeftFlipTree(stack);
		locateNodeAndMap(newNode,tmpRightNode,tmpRightNode.value);
		
		return newNode;
	}
	

	
	private void locateNodeAndMap(Tree.Node newNode,Tree.Node tmpRightNode,int value) {
		Tree.Node foundNode=findNode(newNode,value);	
		if (foundNode != null && foundNode.right == null) {
			foundNode.left= tmpRightNode.left;
			foundNode.right=tmpRightNode.right;
		}
		
		
	}
	
	Tree.Node findNode(Tree.Node node,int value){
		if(node != null){
	        if(node.value == value){
	           return node;
	        } else {
	            Tree.Node foundNode = findNode(node.left,value);
	            if(foundNode == null) {
	                foundNode = findNode(node.right,value);
	            }
	            return foundNode;
	         }
	    } else {
	        return null;
	    }
	    
	    
	}



	private Tree.Node constructLeftFlipTree(Stack <Tree.Node> stack) {
		while(!stack.isEmpty()) {
			Tree.Node tmpNode = stack.pop();
			if (tmpNode != null) {
				if (!insertedNode.containsKey(tmpNode)) {
					RelationShip rs = new RelationShip();
					if (tmpNode.right != null) {
						rs.setRightChild(tmpNode.right);
					} else {
						rs.setRightChild(null);
					}
					if (tmpNode.left != null) {
						rs.setLeftChild(tmpNode.left);
					} else {
						rs.setLeftChild(null);
					}
					insertedNode.put(tmpNode,rs);
					tree.add(tmpNode.value, tree.root,rs);
				}
			}
						
		}
		return tree.root;
	}

    public void printNode(Tree.Node node) {
    	if (node == null) {
			return ;
		}
    	printNode(node.left);
    	System.out.print(node.value+" ");
    	printNode(node.right);
    }

	public static void main(String args[]) {
		  Tree tree = new Tree();
          Tree.Node node = tree.new Node(1);
          node.left = tree.new Node(2); 
          node.right = tree.new Node(3); 
          node.left.left = tree.new Node(4); 
          node.left.right = tree.new Node(5); 
          node.right.left = tree.new Node(6); 
          node.right.right = tree.new Node(7);
          
        
          
          
          FlipBT bt = new FlipBT();
         // bt.printNode(node);
             Tree.Node finalNode=bt.Flip(node,new Stack<Tree.Node>());
         
	}
	
	
}
