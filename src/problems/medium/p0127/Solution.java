package problems.medium.p0127;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 127. Word Ladder

	}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> hs = new HashSet<String>(wordList);
        
        if(!hs.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<String>();
        Queue<Integer> qLevel = new LinkedList<>();
        
        q.add(beginWord);
        qLevel.add(1);
        
        while(!q.isEmpty()){
            String current = q.poll();
            int level = qLevel.poll();
            
            char[] c = current.toCharArray();
            
            for(int i = 0; i < c.length; i++){
                char temp = c[i];
                
                for(int j = 'a'; j <= 'z'; j++){
                    if(c[i] == (char)j)
                        continue;
                    
                    c[i] = (char)j;
                    
                    String s = new String(c);
                    
                    if(endWord.equals(s)) return level + 1;
                    
                    if(hs.contains(s)){
                        q.add(s);
                        qLevel.add(level + 1);
                        hs.remove(s);
                    }
                }
                
                c[i] = temp;
            }
        }
        
        return 0;
    }
}
