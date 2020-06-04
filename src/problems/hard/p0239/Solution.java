package problems.hard.p0239;

public class Solution {

	public static void main(String[] args) {
		// 239. Sliding Window Maximum

	}

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        
        int maxIndex = 0;
        int[] result = new int[nums.length - k + 1];
        
        for(int i = 0; i < k; i++)
            if(nums[i] > nums[maxIndex])
                maxIndex = i;
        
        result[0] = nums[maxIndex];
        
        for(int i = k; i < nums.length; i++){
            if(nums[i] >= nums[maxIndex]){
                maxIndex = i;
            }
            else if(i - k == maxIndex){
                maxIndex = i - k + 1;
                for(int j = i - k + 1; j <= i; j++)
                    if(nums[j] > nums[maxIndex])
                        maxIndex = j;
            }
            
            result[i - k + 1] = nums[maxIndex];
        }
        
        return result;
    }
}
