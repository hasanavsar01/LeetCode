package problems.medium.p0213;

public class Solution {

	public static void main(String[] args) {
		// 213. House Robber II

	}
	
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int result = 0;
        
        for(int i = 0; i < 2; i++){
            int n0 = 0, n1 = 0, n2 = 0;
        
            for(int j = 1 - i; j < nums.length - i; j++){
                int temp = n2;
                n2 = nums[j] + Math.max(n0, n1);
                n0 = n1;
                n1 = temp;
            }
            result = Math.max(result, Math.max(n1, n2));
        }
        return result;
    }
}
