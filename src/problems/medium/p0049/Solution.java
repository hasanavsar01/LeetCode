package problems.medium.p0049;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 49. Group Anagrams

	}
	
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List> result = new HashMap<String, List>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if(!result.containsKey(sorted))
                result.put(sorted, new ArrayList<String>());
            result.get(sorted).add(s);
        }
        return new ArrayList(result.values());
    }

}
