package problems.hard.p0154;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        return func(nums, l, r);
    }
    
    public int func(int nums[], int l, int r){
        if(l == r)
            return nums[l];
        
        if(r - l == 1)
            return nums[l] < nums[r] ? nums[l] : nums[r];
        
        int mid = l + (r - l) / 2;
        
        if(nums[mid] > nums[r])
            return func(nums, mid, r);
        
        if(nums[mid] < nums[r])
            return func(nums, l, mid);
        
        
        int left = func(nums, l, mid);
        int right = func(nums, mid, r);
        
        return Math.min(left, right);
    }
}
