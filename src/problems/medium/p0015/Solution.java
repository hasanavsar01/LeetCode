package problems.medium.p0015;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
        //15. 3Sum

	}

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        
        Arrays.sort(nums);
            
        int index1 = 0;
        
        while(index1 < nums.length - 2){
            if(nums[index1] > 0)
                break;
            
            if(index1 > 0 && nums[index1] == nums[index1 - 1]){
                index1++;
                continue;
            }
            
            int index2 = index1 + 1;
            int index3 = nums.length - 1;
            
            while(index2 < index3){
                
                if(index2 - 1 > index1 && nums[index2] == nums[index2 - 1]){
                    index2++;
                    continue;
                }
                if(index3 < nums.length - 2 && nums[index3] == nums[index3 + 1]){
                    index3--;
                    continue;
                }

                if(nums[index1] + nums[index2] + nums[index3] > 0){
                    index3--;
                    continue;
                }
                else if(nums[index1] + nums[index2] + nums[index3] < 0){
                    index2++;
                    continue;
                }
                else{
                    result.add(new ArrayList());
                    result.get(result.size() - 1).add(nums[index1]);
                    result.get(result.size() - 1).add(nums[index2]);
                    result.get(result.size() - 1).add(nums[index3]);
                    index2++;
                    index3--;
                }
            }
            index1++;
        }
        return result;
    }
}
