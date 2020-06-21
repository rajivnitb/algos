package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/knight-on-chess-board/
 * @author RajivDevaraj
 *
 */
public class ChessBoard {
	
	private Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
	private List <Integer> list = new ArrayList<Integer>();
	private int matrixX = 0;
	private int matrixY = 0;
	private int newX = 0 ;
	private int newY = 0 ;
	
	private int getHopCount(int matrixX,int matrixY,int currentX,
			int currentY,int newX,int newY) {
		this.matrixX=matrixX;
		this.matrixY=matrixY;
		this.newX=newX;
		this.newY=newY;
		int rc=getRoutes(0,currentX,currentY);
		if (rc < 0) {
			return rc ;
		}else {
			for (Integer i : list) {
				rc=Math.min(Integer.MAX_VALUE,i);
			}
		}
		
		return rc ;
	}
	public int getRoutes(int count,int currentX,int currentY) {
	   
		
		if (currentX > matrixX || currentY > matrixY || currentX < 1 || currentY < 1) {
			return -1 ;
		}
		
		if (currentX == newX && currentY == newY) {
			list.add(count);
			return 1;
		}
		
		
		if (isVisted(currentX,currentY) != -1) {
			count=count+1;
		}else {
			return -1 ;
		}
		
		int xleft =getRoutes(count,currentX-1,currentY+2);
		int xRight=getRoutes(count,currentX+1,currentY+2);
		int yleft=getRoutes(count,currentX-1,currentY-2);
		int yRight=getRoutes(count,currentX+1,currentY-2);
		int xleftA =getRoutes(count,currentX-2,currentY+1);
		int xRightA=getRoutes(count,currentX+2,currentY+1);
		int yleftA=getRoutes(count,currentX-2,currentY-1);
		int yRightA=getRoutes(count,currentX+2,currentY-1);
		
		if (xleft == 1 || xRight == 1 || yleft == 1 || yRight == 1 || xleftA == 1
				|| xRightA == 1 || yleftA == 1 || yRightA == 1) {
			return 1 ;
		}
		else {
			return -1;
		}
		
	}
	
	
	private int isVisted(int currentX,int currentY) {
		if (map.containsKey(currentX)) {

			for (Integer i : map.get(currentX)) {
				if (i.equals(currentY)) {
					return -1;
				}
			}
			map.get(currentX).add(currentY);

		}else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(currentY);
			map.put(currentX,list);
			
		}
		return 1;
	}
	
	public static void main(String args[]) {
		
		int currentX=4;
		int currentY=2;
		int newX=4;
		int newY=6;
		ChessBoard chessB= new ChessBoard();
		System.out.println(chessB.getHopCount(6,6, currentX, currentY,newX,newY));
		
		
	}

}
