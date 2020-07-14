package problems.medium.p0279;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 279. Perfect Squares

	}

    public int numSquares(int n) {
        List<Integer> list = new ArrayList();
        
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            if(Math.sqrt(i) % 1 == 0)
                list.add(i);
            
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < list.size(); j++)
                min = Math.min(min, dp[i - list.get(j)]);
            
            dp[i] = min + 1;
        }
        
        return dp[n];
    }
}
