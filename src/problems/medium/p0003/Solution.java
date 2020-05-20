package problems.medium.p0003;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 3. Longest Substring Without Repeating Characters

	}
	
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet();
        int r = 0;
        int l = 0;
        int maxLen = 0;
        while(r < s.length()){
            while(hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l++));
            }
            hs.add(s.charAt(r++));
            maxLen = Math.max(maxLen, hs.size());
        }
        return maxLen;
    }

}
