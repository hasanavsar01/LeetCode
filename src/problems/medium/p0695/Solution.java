package problems.medium.p0695;

public class Solution {

	public static void main(String[] args) {
		// 695. Max Area of Island

	}
	
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                max = Math.max(max, func(grid, i, j, 0));
            }
        }
        
        return max;
    }
    
    public int func(int[][] grid, int row, int col, int count){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return count;
        
        grid[row][col] = 0;
        
        int n1 = func(grid, row + 1, col, count);
        int n2 = func(grid, row - 1, col, count);
        int n3 = func(grid, row, col + 1, count);
        int n4 = func(grid, row, col - 1, count);
        
        
        return n1 + n2 + n3 + n4 + 1;
    }

}
