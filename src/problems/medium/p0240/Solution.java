package problems.medium.p0240;

public class Solution {

	public static void main(String[] args) {
		// 240. Search a 2D Matrix II

	}

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            if(matrix[rowEnd][colEnd] < target)
                return false;
            
            while(matrix[rowBegin][colEnd] < target)
                rowBegin++;
            
            if(matrix[rowBegin][colEnd] == target)
                return true;
            
            while(matrix[rowEnd][colBegin] < target)
                colBegin++;
            
            if(matrix[rowEnd][colBegin] == target)
                return true;
            
            rowEnd--;
            colEnd--;
        }
        return false;
    }
}
