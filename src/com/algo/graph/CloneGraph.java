package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/clone-graph/
 * @author RajivDevaraj
 *
 */
public class CloneGraph {
	
	private GraphNode getNewGraphNode(GraphNode node) {
		return graphClone(node, new HashMap<Integer,GraphNode>()).entrySet().iterator().next().getValue();
	}

	private Map<Integer,GraphNode> graphClone(GraphNode node,Map <Integer,GraphNode> mpGraph) {
	   
		if (mpGraph.containsKey(node.val)) {
			return null;
		}
		
		GraphNode newNode = new GraphNode(node.val);
		mpGraph.put(newNode.val,newNode);
		for (GraphNode listNode : node.neighbours) {
			newNode.neighbours.add(listNode);
			graphClone(listNode,mpGraph);
		}
		
		
		return mpGraph;
		
		
		
	}
	
	public static void main(String args[]) {
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		List<GraphNode> v = new ArrayList<GraphNode>(); 
        v.add(node2); 
        v.add(node4); 
        node1.neighbours = v; 
        v = new ArrayList<GraphNode>(); 
        v.add(node1); 
        v.add(node3); 
        node2.neighbours = v; 
        v = new ArrayList<GraphNode>(); 
        v.add(node2); 
        v.add(node4); 
        node3.neighbours = v; 
        v = new ArrayList<GraphNode>(); 
        v.add(node3); 
        v.add(node1); 
        node4.neighbours = v; 
        
        CloneGraph graph = new CloneGraph();
        GraphNode node =graph.getNewGraphNode(node1);
        System.out.println(node.val);
       // System.out.println(node.val+"---->"+node.neighbours);
	}
}
