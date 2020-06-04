package problems.medium.p0078;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 78. Subsets

	}
	
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());

		for(int num : nums){
			List<List<Integer>> localResult = new ArrayList<>();
			
			for(List<Integer> list : result){
				List<Integer> newList = new ArrayList<>(list);
				newList.add(num);
				localResult.add(newList);
				}
			
			for(List<Integer> list : localResult){
				result.add(list);
				}
			}
		
		return result;
	}
}
