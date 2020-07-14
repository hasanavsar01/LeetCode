package problems.easy.p0198;

public class Solution {

	public static void main(String[] args) {
		// 198. House Robber

	}
	
    public int rob(int[] nums) {
        int n0 = 0, n1 = 0, n2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            nums[i] += Math.max(n0, n1);
            n0 = n1;
            n1 = n2;
            n2 = nums[i];
        }
        
        return Math.max(n1, n2);
    }
}
