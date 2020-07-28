package problems.medium.p0621;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        
        for(char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        
        maxHeap.addAll(map.values());
        
        int time = 0;
        
        while(!maxHeap.isEmpty()){
            List<Integer> list = new ArrayList();
            for(int i = 0; i < n + 1; i++)
                if(!maxHeap.isEmpty())
                    list.add(maxHeap.poll());
            
            for(int i : list)
                if(--i > 0)
                    maxHeap.offer(i);
            
            time += !maxHeap.isEmpty() ? n + 1 : list.size();
        }
        
        return time;
    }
}
