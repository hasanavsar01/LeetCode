package problems.medium.p0516;

public class Solution {

	public static void main(String[] args) {
		// 516. Longest Palindromic Subsequence

	}

    public int longestPalindromeSubseq(String s) {
        if(s.length() < 2)
            return s.length();
        
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(s.charAt(s.length() - i) == s.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
            }
        }
        
        return dp[s.length()][s.length()];
    }
}
