package com.algo.string;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * @author RajivDevaraj
 *
 */
public class ZigZac {

	public String convert(String s, int numRows) {
        String [][]a = new String[numRows][s.length()-1];
        mapData(a, s, numRows);
        return printData(a,numRows,s.length());
	}
	
	
	public String printData(String [][]a,int numRows,int yLength) {
		String s = "";
		for (int x =0 ; x <= numRows-1 ; x ++) {
			for (int y=0 ; y < yLength-1 ; y++) {
				if (a[x][y] != null) {
					s+=a[x][y];
				}
			}
		}
		return s;
	}
	
    public void mapData(String [][]a,String s,int numRows){
    	int x = 0 ;
    	int y = 0 ;
    	boolean isInverse = false ;
		for (int i = 0 ; i <=s.length()-1; i++) {
			a[x][y]=String.valueOf(s.charAt(i));
			
			if (x ==0) {
				isInverse=false;
			}
			if (x >=0 && x < numRows-1 && !isInverse) {
				x++ ;
			}else {
				if (x == numRows-1) {
					x=numRows-2;
					isInverse=true;
				}else {
					if (x > 0) {
					x-- ;
					}else {
						isInverse=false;
					}
				}
				if (isInverse)
				y++;
			}
			
		}
	}

	public static void main(String args[]) {

		ZigZac zac = new ZigZac();
		System.out.println(zac.convert("PAYPALISHIRING",4));
	}
}
