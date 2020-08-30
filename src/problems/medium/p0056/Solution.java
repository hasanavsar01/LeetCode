package problems.medium.p0056;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 56. Merge Intervals

	}

    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2)
            return intervals;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<List<Integer>> pairs = new ArrayList();
        
        int begin = intervals[0][0];
        int end   = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
                continue;
            }
            
            List<Integer> list = new ArrayList();
            list.add(begin);
            list.add(end);
            pairs.add(list);
            
            begin = intervals[i][0];
            end   = intervals[i][1];
        }
        
        List<Integer> list = new ArrayList();
        list.add(begin);
        list.add(end);
        pairs.add(list);
        
        intervals = new int[pairs.size()][2];
        
        for(int i = 0; i < intervals.length; i++){
            intervals[i][0] = pairs.get(i).get(0);
            intervals[i][1] = pairs.get(i).get(1);
        }
        
        return intervals;
    }
}
