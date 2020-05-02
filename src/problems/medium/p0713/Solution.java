package problems.medium.p0713;

public class Solution {

	public static void main(String[] args) {
		// 713. Subarray Product Less Than K

	}
	
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    	
    	//Important! Product will never be less than 1
        if(k <= 1)
            return 0;
        
        int l = 0;
        int r = 0;
        int result = 0;
        int product = 1;
        
        while(r < nums.length){
            product *= nums[r];
            
            while(product >= k){
                product /= nums[l++];
            }
            
            result += r - l + 1;
            
            r++;
        }
        
        return result;
    }
}
