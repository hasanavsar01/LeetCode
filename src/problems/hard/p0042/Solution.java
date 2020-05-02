package problems.hard.p0042;

public class Solution {

	public static void main(String[] args) {
		// 42. Trapping Rain Water

	}
	
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int level = 0;
        int trapped = 0;
        
        while(l < r){
            level = height[l] < height[r] ? height[l] : height[r];
            
            for(int i = l; i < r; i++){
                if(level - height[i] > 0){
                    trapped += level - height[i];
                    height[i] = level;
                }
            }
            
            if(height[l] < height[r])
                l++;
            else if(height[l] > height[r])
                r--;
            else{
                l++;
                r--;
            }
        }
        
        return trapped;
    }
}
