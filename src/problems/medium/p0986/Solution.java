package problems.medium.p0986;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 986. Interval List Intersections

	}

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        int a = A.length - 1;
        int b = B.length - 1;
        
        while(a >= 0 && b >= 0){
            if(!(A[a][0] > B[b][1] || B[b][0] > A[a][1])){
                int[] temp = new int[] {A[a][0], A[a][1], B[b][0], B[b][1]};
                Arrays.sort(temp);
                List<Integer> l = new ArrayList();
                l.add(temp[1]);
                l.add(temp[2]);
                result.add(l);
            }
            
            if(A[a][0] > B[b][0])
                a--;
            else
                b--;
        }
        
        int[][] intersect = new int[result.size()][2];
        
        for(int i = 0; i < result.size(); i++){
            intersect[intersect.length - 1 - i][0] = result.get(i).get(0);
            intersect[intersect.length - 1 - i][1] = result.get(i).get(1);
        }
        return intersect;
    }
}
