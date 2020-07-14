package problems.medium.p0377;

public class Solution {

	public static void main(String[] args) {
		// 377. Combination Sum IV

	}
	
    public int combinationSum4(int[] nums, int target){
	    int[] dp = new int[target + 1];
	    
	    dp[0] = 1;
	    
	    for (int i = 1; i < target + 1; i++){
	    	for (int k : nums){
	            if (i - k >= 0) dp[i] += dp[i-k];
	        }
	    }
	    
	    return dp[target]; 
    }
}
