package problems.medium.p0039;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 39. Combination Sum

	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        
        dfs(result, new ArrayList<Integer>(), candidates, 0, target, 0);
        
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> current, int[] candidates, int index, int target, int sum){
        if(sum > target) return;
        
        if(sum == target){
            result.add(current);
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            
            if(sum + candidates[i] <= target){
                List<Integer> temp = new ArrayList<Integer>(current);
                temp.add(candidates[i]);

                dfs(result, temp, candidates, i, target, sum + candidates[i]);
            }
            else break;
        }
        
        return;
    }

}
