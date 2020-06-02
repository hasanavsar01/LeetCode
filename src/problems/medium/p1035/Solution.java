package problems.medium.p1035;

public class Solution {

	public static void main(String[] args) {
		// 1035. Uncrossed Lines
		// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/

	}
	
    public int maxUncrossedLines(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0) return 0;
            
        int[][] matrix = new int[A.length + 1][B.length + 1];
        
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                if(A[i - 1] == B[j - 1])
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
        
        return matrix[A.length][B.length];
    }

}
