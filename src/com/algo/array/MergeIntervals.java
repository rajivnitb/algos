package com.algo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * https://www.interviewbit.com/problems/merge-overlapping-intervals/
 * @author RajivDevaraj
 *
 */
public class MergeIntervals {
	
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	
	public List<Interval> insert(ArrayList<Interval> intervals) {
		Collections.sort(intervals,new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start; 
			}
			
		});
		CopyOnWriteArrayList<Interval> list = new CopyOnWriteArrayList<MergeIntervals.Interval>(intervals);
		Interval firstInterval=list.remove(0);
		ArrayList<Interval> intervalList = new ArrayList<>(); 
		for (Interval tmpInt : list) {
			if (tmpInt.start > firstInterval.end) {
				intervalList.add(firstInterval);
				firstInterval=tmpInt;
				continue ;
			}
			if (tmpInt.start < firstInterval.start) {
				firstInterval.start=tmpInt.start;
			}else {
				if (tmpInt.end < firstInterval.start) {
					firstInterval.start=tmpInt.end;
				}
			}
			if (firstInterval.end < tmpInt.end) {
				firstInterval.end=tmpInt.end;
			}
			
			
		}
		intervalList.add(firstInterval);
		return intervalList;
	}
	 
	
	public static void main(String args[]) {
		MergeIntervals mI = new MergeIntervals();
		MergeIntervals.Interval it1 =mI.new Interval(6,8);
		MergeIntervals.Interval it2 =mI.new Interval(1,9);
		MergeIntervals.Interval it3 =mI.new Interval(2,4);
		MergeIntervals.Interval it4 =mI.new Interval(4,7);
		
		
		ArrayList<Interval> ls = new ArrayList<>();
		ls.add(it1);
		ls.add(it2);
		ls.add(it3);
		ls.add(it4);

		System.out.println(mI.insert(ls));
	}

}
