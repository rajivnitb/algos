package com.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

	public int val;
	public List<GraphNode> neighbours;
	    
	public GraphNode() {
	    val = 0;
	    neighbours = new ArrayList<GraphNode>();
	}
	    
	public GraphNode(int _val) {
	     val = _val;
	     neighbours = new ArrayList<GraphNode>();
	}
	    
	public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
	        val = _val;
	        neighbours = _neighbors;
	}
	

   

}
