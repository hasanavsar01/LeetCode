package problems.medium.p0139;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 139. Word Break

	}

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        
        List<StringBuilder> search = new ArrayList<>();
        search.add(new StringBuilder(""));
        
        for(char c : s.toCharArray()){
            for(StringBuilder sb : search){
                sb.append(c);
            }
            
            for(StringBuilder sb : search){
                if(hs.contains(sb.toString())){
                    search.add(new StringBuilder(""));
                    break;
                }
            }
        }
        
        if(search.get(search.size() - 1).length() == 0)
            return true;
        
        return false;
    }
}
