package problems.medium.p0153;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l < r){
            if(nums[l] < nums[r])
                return nums[l];
            
            int mid = l + (r - l) / 2;
            
            if(nums[l] <= nums[mid])
                l = mid + 1;
            else
                r = mid;
        }
        
        return nums[l];
    }
}
