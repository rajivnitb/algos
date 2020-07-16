package com.algo.graph;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
 * @author RajivDevaraj
 *
 */
public class DistanceGraph {

	int count =Integer.MIN_VALUE;
	ArrayList <Integer> list = new ArrayList<Integer>();
	public int getMaxDist(GraphNode gN,int tmpCount) {
		
		if (gN != null) {
			if (list.contains(gN.val)) {
				return tmpCount;
			}
			list.add(gN.val);
		}else {
			return tmpCount;
		}
		
		if (gN.neighbours.isEmpty()) {
			count= Math.max(count,tmpCount+1);
			return count;
		}
		
		for (GraphNode gn : gN.neighbours) {
			 tmpCount=getMaxDist(gn,tmpCount+1);
			 tmpCount=0;
				
		}
		
		return count;
	}
	
	public static void main(String args[]) {
		GraphNode gN = new GraphNode(0);
		GraphNode gN1 =new GraphNode(1);
		GraphNode gN2 =new GraphNode(2);

		GraphNode gN3 = new GraphNode(3);
		GraphNode gN4 = new GraphNode(4);
		GraphNode gN5 = new GraphNode(5);

		gN.neighbours.add(gN1);
		gN.neighbours.add(gN2);
		gN.neighbours.add(gN3);
		gN3.neighbours.add(gN4);
		gN4.neighbours.add(gN5);
		DistanceGraph dG=new DistanceGraph();
		dG.getMaxDist(gN,0);
		System.out.println(dG.count);
	}
}
