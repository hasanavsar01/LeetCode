package problems.medium.p0033;

public class Solution {

	public static void main(String[] args) {
		// Search in Rotated Sorted Array

	}

    public static int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            
            if(nums[mid] == target) return mid;
            
            if(nums[mid] >= nums[l]){
                if(target > nums[mid] || target < nums[l])
                    l = mid + 1;
                else
                    r = mid;
            }
            else{
                if(target < nums[mid] || target > nums[r])
                    r = mid - 1;
                else
                    l = mid;
            }
        }
        return -1;
    }
}
