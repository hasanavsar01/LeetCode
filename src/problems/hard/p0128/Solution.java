package problems.hard.p0128;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 128. Longest Consecutive Sequence

	}

    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();
        
        int max = 0;
        
        for(int n : nums)
            if(!hs.contains(n))
                hs.add(n);
        
        for(int n : nums){
            int begin = n;
            int end = n;
            hs.remove(n);
            
            while(hs.contains(end + 1)){
                hs.remove(end + 1);
                end++;
            }
            
            while(hs.contains(begin - 1)){
                hs.remove(begin - 1);
                begin--;
            }
            
            max = Math.max(max, end - begin + 1);
        }
        
        return max;
    }
}
