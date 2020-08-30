package problems.medium.p0994;

public class Solution2 {

	public static void main(String[] args) {
		// TODO 994. Rotting Oranges

	}

    public int orangesRotting(int[][] grid) {
        int remains = 0;
        int time = 0;
        
        while(true){
            boolean rots = false;
            remains = 0;

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == 1){
                        if(func(grid, i, j))
                            rots = true;
                        else
                            remains++;
                    }
                }
            }

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == -1){
                    	grid[i][j] = 2;
                    }
                }
            }
            
            if(rots)
                time++;
            else
                break;
        }
        
        if(remains > 0)
            return -1;
        
        return time;
    }
    
    public boolean func(int[][] grid, int row, int col){
        if(row > 0 && grid[row - 1][col] == 2 ||
           row < grid.length - 1 && grid[row + 1][col] == 2 ||
           col > 0 && grid[row][col - 1] == 2 ||
           col < grid[0].length - 1 && grid[row][col + 1] == 2
          ){
            grid[row][col] = -1;
            return true;
        }
        
        return false;
    }
}
