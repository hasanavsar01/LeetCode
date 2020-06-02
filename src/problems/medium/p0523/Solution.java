package problems.medium.p0523;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 523. Continuous Subarray Sum

	}
	
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2)
            return false;
        
        Map<Integer, Integer> m = new HashMap();
        m.put(0, -1);
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(k != 0)
                sum %= k;
            
            if(m.containsKey(sum)){
                
                int index1 = m.get(sum);
                
                if(i - index1 > 1)
                    return true;
            }
            else{
                m.put(sum, i);
            }
        }
        return false;
    }
}
