package problems.medium.p1277;

public class Solution {

	public static void main(String[] args) {
		// TODO 1277. Count Square Submatrices with All Ones

	}

    public int countSquares(int[][] matrix) {
        int count = 0;
        
        for(int i = 1; i < matrix.length; i++)
            for(int j = 1; j < matrix[i].length; j++)
                if(matrix[i][j] == 1) //don't forget to check whether cell has value 1.
                    matrix[i][j] = Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]) + 1;
        
        
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                count += matrix[i][j];
        
        return count;
    }
}
