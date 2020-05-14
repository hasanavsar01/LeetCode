package problems.medium.p0048;

public class Solution {

	public static void main(String[] args) {
		// 48. Rotate Image (2D Matrix)

	}
	
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        int turns = n/2;
        
        for(int i = 0; i < turns; i++){
            int a = i;
            int b = n - i - 1;
            for(int j = 0; j < b - a; j++){
                int temp = matrix[a][a + j];
                matrix[a][a + j] = matrix[b - j][a];
                matrix[b - j][a] = matrix[b][b - j];
                matrix[b][b - j] = matrix[a + j][b];
                matrix[a + j][b] = temp;
            }
        }
    }
}
