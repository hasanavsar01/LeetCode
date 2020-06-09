package problems.medium.p0518;

public class Solution {

	public static void main(String[] args) {
		// 518. Coin Change 2

	}
	
	public int change(int amount, int[] coins) {
		if(coins == null || coins.length == 0)
			return amount == 0 ? 1 : 0;
		
		int[] dp = new int[amount + 1];
		
		dp[0] = 1;
		
		for(int i = 0; i < coins.length; i++) {
			for(int j = 1; j <= amount; j++) {
				if(j >= coins[i])
					dp[j] += dp[j - coins[i]];
			}
		}
		
		return dp[amount];
	}

}
