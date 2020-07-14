package problems.medium.p0054;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList();
        
        if(matrix.length == 0 || matrix[0].length == 0)
            return spiral;
        
        int top = 0;
        int bot = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        int row = 0;
        int col = 0;
        
        while(left <= right && top <= bot){
            if(col > right) break;
            while(col <= right)
                spiral.add(matrix[row][col++]);
            right--;
            col--;
            row++;
            
            if(row > bot) break;
            while(row <= bot)
                spiral.add(matrix[row++][col]);
            bot--;
            row--;
            col--;
            
            if(col < left) break;
            while(col >= left)
                spiral.add(matrix[row][col--]);
            left++;
            col++;
            row--;
            
            if(row <= top) break;
            while(row > top)
                spiral.add(matrix[row--][col]);
            top++;
            row++;
            col++;       
        }
        
        return spiral;
    }
    
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int startRow = 0, endRow = matrix.length - 1, startCol = 0, endCol = matrix[0].length - 1;
        
        while (startRow <= endRow && startCol <= endCol) {
            
            for (int i = startCol; i <= endCol; i++) {
                list.add(matrix[startRow][i]);
            }
            
            
            for (int i = startRow + 1; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }
            
            if (startRow >= endRow || startCol >= endCol) break;
            
            for (int i = endCol - 1; i > startCol; i--) {
                list.add(matrix[endRow][i]);
            }
            
            for (int i = endRow; i > startRow; i--) {
                list.add(matrix[i][startCol]);
            }
            
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        
        return list;
    }
}
