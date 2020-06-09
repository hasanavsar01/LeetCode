package problems.medium.p0322;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// 322. Coin Change

	}
	
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        
        for(int i = 1; i <= amount; i++){
            int minCoins = -1;
            
            for(int coin : coins){
                if(i - coin >= 0){
                    if(cache[i - coin] == -1)
                        continue;
                        
                    int currCoins = cache[i - coin] + 1;

                    if(minCoins == -1 || currCoins < minCoins)
                        minCoins = currCoins;
                }
            }
            cache[i] = minCoins;
        }
        return cache[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return amount == 0 ? 0 : -1;
        
        Arrays.sort(coins);
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j >= coins[i] && dp[j - coins[i]] > -1)
                    if(dp[j] == -1 || dp[j] > dp[j - coins[i]] + 1)
                        dp[j] = dp[j - coins[i]] + 1;
            }
        }
        
        return dp[amount];
    }
}
