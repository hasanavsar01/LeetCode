package problems.medium.p0994;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 994. Rotting Oranges

	}
	
	public int orangesRotting(int[][] grid) {
        LinkedList<Integer> rowQ = new LinkedList();
        LinkedList<Integer> colQ = new LinkedList();
        LinkedList<Integer> minQ = new LinkedList();
        int max = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    rowQ.add(i);
                    colQ.add(j);
                    minQ.add(0);
                }
            }
        }
        
        while(!rowQ.isEmpty()){
            int row = rowQ.poll();
            int col = colQ.poll();
            int min = minQ.poll();
            
            max = Math.max(max, helper(grid, rowQ, colQ, minQ, row + 1, col, min));
            max = Math.max(max, helper(grid, rowQ, colQ, minQ, row, col + 1, min));
            max = Math.max(max, helper(grid, rowQ, colQ, minQ, row - 1, col, min));
            max = Math.max(max, helper(grid, rowQ, colQ, minQ, row, col - 1, min));
        }
        
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return max;
    }
    
    public int helper(int[][] grid, LinkedList<Integer> rowQ, LinkedList<Integer> colQ, LinkedList<Integer> minQ, int row, int col, int min){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == 2){
            return 0;
        }
        
        grid[row][col] = 2;
        
        rowQ.add(row);
        colQ.add(col);
        minQ.add(min + 1);
        
        return min + 1;
    }

}
