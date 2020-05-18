package problems.medium.p0438;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 438. Find All Anagrams in a String

	}
	
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        int[] ss = new int[26];
        int[] pp = new int[26];
        
        for(char c : p.toCharArray())
            pp[c - 'a']++;
        
        for(int i = 0; i < s.length(); i++){
            ss[s.charAt(i) - 'a']++;
            
            if(i >= p.length())
                ss[s.charAt(i - p.length()) - 'a']--;
            
            if(Arrays.equals(ss, pp))
                result.add(i - p.length() + 1);
            
        }
        
        return result;
    }

}
