package problems.medium.p0540;

public class Solution {

	public static void main(String[] args) {
		// 540. Single Element in a Sorted Array

	}

    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l < r){
            
            int mid = l + (r - l) / 2;
            
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            
            if(nums[mid] == nums[mid - 1]){
                if(mid % 2 == 0)
                    r = mid;
                else
                    l = mid + 1;
            }
            else{
                if(mid % 2 == 1)
                    r = mid - 1;
                else
                    l = mid;
            }
        }
        
        return nums[l];
    }
}
