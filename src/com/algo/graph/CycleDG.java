package com.algo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/cycle-in-directed-graph/
 * @author rajiv
 *
 */
public class CycleDG {

	void getEdges(Graph graph) {
		for (int i = 1; i <=5; i++) {
			if(!isValidCycle(graph,i)) {
				return ;
			}
			List<Integer> list = graph.getEdge(i);
			List<Integer> tmpList=new ArrayList<Integer>();
			tmpList.add(i);
			List<List<Integer>> finalList=getEdgesOfEdges(graph,list,i,tmpList,new ArrayList<List<Integer>>());
			System.out.println(finalList);
		}
	}
	
	boolean isValidCycle(Graph graph,int j){
		for (int i =1 ; i < 5 ; i ++) {
			if (graph.getEdge(i).contains(j)){
				return true;
			}
		}
		return false ;
	}
	
	private List<List<Integer>> getEdgesOfEdges(Graph graph,List <Integer>list,int firstPoint,List<Integer> path,List<List<Integer>> data) {
		
		for (Integer i : list) {
			
			if (firstPoint == i) {
				List<Integer> tempList=new ArrayList<Integer>(path);
				tempList.add(i);
				data.add(tempList);
				
				return data ;
			}
			if (isVisitedNode(path,i)) {
				return data;
			}
			path.add(i);
			
			getEdgesOfEdges(graph,graph.getEdge(i), firstPoint,path,data);
			path.remove(path.size()-1);
		
		}
		return data ;
	}
	
	
 
	
	boolean isVisitedNode(List<Integer> list,int value) {
	//	Collections.sort(list);
		if (list.contains(value)) {
			return true ;
		}
		return false ;
	}

	public static void main(String args[]) {
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(4,1);
		graph.addEdge(2,4);
		graph.addEdge(3,4);
		graph.addEdge(5,2);
		graph.addEdge(1,3);
		new CycleDG().getEdges(graph);
	}
	
	
}
