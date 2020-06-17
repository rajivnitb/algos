package com.algo.graph;

/**
 * https://www.interviewbit.com/problems/word-search-board/
 * @author RajivDevaraj
 *
 */
public class WordSearchBoard {
	

	int[] x = {-1,0,1,-1,1,-1,0,1};
	int [] y= {1,-1,-1,0,0,-1,1,1};
	
	static int R = 2; 
    static int C = 12; 
	
    private int findWordCount(char c [][],String word,int row ,int col) {
    	
    	
    	int val = 0 ;
    	
    	for (int i = 0 ; i < 8 ; i++) {
    		int index = 1 ;
    		int tRow = row ; 
        	int tCol =col ;
    		while (word.length()-1 >= index) {
    			tRow=tRow+x[i];
    			tCol=tCol+y[i];
    		
    		if (tRow > R || tCol > C || tRow < 0 || tCol < 0) {
    			break ;
    		}
				if (c[tRow][tCol] != word.charAt(index)) {
					break;
				}
				
				if (word.length()-1 == index) {
					val=val+1;
				}
				index ++ ;
    		}
    		
    		
    	}
    	return val;
    }
    
    
	
	public static void main(String args[]) {
		WordSearchBoard wb = new WordSearchBoard();
		
	    String s = "GEEKS";
	    int count = 0;
		char[][] grid = {{'G','E','E','K','S','F','O','R','G','E','E','K','S'}, 
                             {'G','E','E','K','S','Q','U','I','Z','G','E','E','K'}, 
                             {'I','D','E','Q','A','P','R','A','C','T','I','C','E'}};
         
        for (int i = 0 ; i <= R ; i ++) {
        	for (int j = 0 ; j <= C ; j++) {
        		 if (grid[i][j] == s.charAt(0)) {
        			 count=count+wb.findWordCount(grid,s,i,j);
        		 }
        	}
        }
        
        System.out.println(count);
	}
}
