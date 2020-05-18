package problems.medium.p0918;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 918. Maximum Sum Circular Subarray

	}
	
    public int maxSubarraySumCircular(int[] A) {
        if(A.length == 0) return 0;
        if(A.length == 1) return A[0];
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i < A.length; i++){
            A[i] += A[i - 1];
        }
        
        PriorityQueue<Integer> qMin = new PriorityQueue<Integer>();
        PriorityQueue<Integer> qMax = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int lastVal = A[A.length - 1];
        
        for(int i = 0; i < A.length; i++){
            
            if(!qMin.isEmpty()){
                max = Math.max(max, A[i] - qMin.peek());
            }
            
            qMin.add(A[i]);
            qMax.add(A[i]);
            
            max = Math.max(max, lastVal - A[i] + qMax.peek());
        }
        
        return max;
    }
    
    public static int maxSubarraySumCircular2(int[] A) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum1 = 0, sum2 = 0, total = 0;
        for(int x : A) {
            if(sum1<0){
                sum1 = 0;
            }
            sum1 += x;
            max = Math.max(max, sum1);
            if(sum2>0){
                sum2 = 0;
            }
            sum2 += x;
            min = Math.min(min, sum2);
            total += x;
        }
        return max > 0 ? Math.max(max, total - min) : max;
      }
}
