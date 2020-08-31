package problems.medium.p0494;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
    public int findTargetSumWays(int[] nums, int S) {
        
        int sum = 0;
        for(int n : nums)
            sum += n;
        
        if(S > sum || S < sum * -1)
            return 0;
        
        int[] targets = new  int[2 * sum + 1];
        targets[sum] = 1;
        
        for(int i = 0; i < nums.length; i++){
            int[] temp = new int[2 * sum + 1];
            
            for(int j = 0; j < targets.length; j++){
                if(targets[j] > 0){
                    temp[j + nums[i]] += targets[j];
                    temp[j - nums[i]] += targets[j];
                }
            }
            
            targets = temp;
        }
        
        return targets[sum + S];
    }

    public int findTargetSumWays2(int[] nums, int S) {
        
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        
        for(int n : nums){
            Map<Integer, Integer> temp = new HashMap();
            
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                
                temp.put(entry.getKey() + n, temp.getOrDefault(entry.getKey() + n, 0) + entry.getValue());
                temp.put(entry.getKey() - n, temp.getOrDefault(entry.getKey() - n, 0) + entry.getValue());
            }
            
            map = temp;
        }
        
        return map.getOrDefault(S, 0);
    }
}
