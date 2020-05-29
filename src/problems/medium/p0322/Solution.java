package problems.medium.p0322;

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

}
