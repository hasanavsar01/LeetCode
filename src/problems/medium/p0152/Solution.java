package problems.medium.p0152;

public class Solution {

	public static void main(String[] args) {
        //152. Maximum Product Subarray

	}
	
    public int maxProduct(int[] nums) {
    	
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
    
    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        int left = 1;
        int right = 1;
        
        for(int i = 0; i < nums.length; i++){
            left *= nums[i];
            right *= nums[nums.length - 1 - i];
            
            max = Math.max(max, Math.max(left, right));
            
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;
        }
        
        return max;
    }
}
