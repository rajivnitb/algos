package com.algo.graph;

public class CRB {

	private int x = 6;
	private int y = 6;

	enum Dir {
		LEFT, RIGHT, TOP, BOTTOM;
	}

	private static char[][] mat = {
			{ 'X', 'O', 'X', 'O', 'X', 'X' },
			{ 'X', 'O', 'X', 'X', 'O', 'X' },
			{ 'X', 'X', 'X', 'O', 'X', 'X' },
			{ 'O', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'X', 'X', 'O', 'X', 'O' },
			{ 'O', 'O', 'X', 'O', 'O', 'O' } };

	public void replace() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (mat[i][j] == 'O') {
					boolean l =update(mat, i, j,Dir.LEFT);
					boolean r =update(mat, i, j,Dir.RIGHT);
					boolean t =update(mat, i, j,Dir.TOP);
					boolean b =update(mat, i, j,Dir.BOTTOM);
					
					if (r && l && t && b) {
						mat[i][j]='X';
					}
				}
			}
		}
	}

	public boolean update(char [][] c,int i ,int j,Dir dir) {
		
		if (!((i < 6  && i >= 0) && ( j < 6 && j >= 0))) {
			return false;
		}
		
		if (c[i][j] == 'X') {
			return true ;
		}

		if (Dir.LEFT == dir) {
			boolean l = update(c, i - 1, j, dir.LEFT);
			if (l) {
				return true;
			}
		}
		if (Dir.RIGHT == dir) {
			boolean l = update(c, i+1, j, dir.RIGHT);
			if (l) {
				return true;
			}
		}
		if (Dir.TOP == dir) {
			boolean l = update(c, i, j-1, dir.TOP);
			if (l) {
				return true;
			}
		}
		if (Dir.BOTTOM == dir) {
			boolean l = update(c, i - 1, j, dir.BOTTOM);
			if (l) {
				return true;
			}
		}
		return false;
		
		

	  
		
	  }

	public static void main(String args[]) {

		 new CRB().replace();
		 for (int i = 0; i < mat.length; i++) {
			    for (int j = 0; j < mat[i].length; j++) {
			        System.out.print(mat[i][j] + " ");
			    }
			    System.out.println();
			}
		//new CRB().update(mat, 4, 3,Dir.RIGHT);
	}

}
