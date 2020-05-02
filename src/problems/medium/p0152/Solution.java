package problems.medium.p0152;

public class Solution {
    public int maxProduct(int[] nums) {
        //152. Maximum Product Subarray
    	
        if(nums.length == 1)
            return nums[0];
        
        int max = nums[0]; 
        int minProduct = nums[0];
        int maxProduct = nums[0];
        int temp = 0;
        
        for(int i = 1; i < nums.length; i++){
            temp = maxProduct;
            
            maxProduct = Math.max(Math.max(maxProduct * nums[i], minProduct * nums[i]), nums[i]);
            minProduct = Math.min(Math.min(temp       * nums[i], minProduct * nums[i]), nums[i]);
            
            max = Math.max(maxProduct, max);
        }
        
        return max;
    }
}
