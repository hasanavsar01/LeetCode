package problems.medium.p0238;

public class Solution {

	public static void main(String[] args) {
		// 238. Product of Array Except Self

	}

    public int[] productExceptSelf(int[] nums) {
        int[] numsLeft = nums.clone();
        int[] numsRight = nums.clone();
        
        for(int i = 1; i < nums.length; i++){
            numsLeft[i] *= numsLeft[i - 1];
            
            numsRight[numsRight.length - 1 - i] *= numsRight[numsRight.length - i];
        }
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = (i == 0 ? 1 : numsLeft[i - 1]) * (i == nums.length - 1 ? 1 : numsRight[i + 1]);
        }
        
        return nums;
    }
}
