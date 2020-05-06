package problems.hard.p0041;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 41. First Missing Positive

	}
	
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)
            return 1;
        
        Arrays.sort(nums);
        
        if(nums[nums.length - 1] < 1)
            return 1;
        
        int index = 0;
        int missing = 1;
        
        while(nums[index] < 1)
            index++;
        
        for(int i = 0; i + index < nums.length; i++){
            if(i > 0 && nums[i + index] == nums[i + index - 1]) continue;
            
            if(nums[i + index] > missing)
                return missing;
            missing++;
        }
        
        return missing;
    }

}
