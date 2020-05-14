package problems.hard.p0084;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 84. Largest Rectangle in Histogram

	}

    public int largestRectangleArea1(int[] heights) {
        if(heights.length == 0) return 0;
        
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        
        for(int i = 0; i <= heights.length; i++){
            while(s.size() > 0 && (i >= heights.length || heights[s.peek()] > heights[i]) ){
                int top = heights[s.pop()];

                int area = s.size() == 0 ? i * top : (i - s.peek() - 1) * top;

                maxArea = Math.max( maxArea, area);
            }

            s.push(i);
        }
        
        return maxArea;
    }
    
    public int largestRectangleArea2(int[] heights) {
        
        HashSet<Integer> hs = new HashSet<Integer>();
        int sizeMax = 0;
        
        for(int i = 0; i < heights.length; i++){
            if(!hs.contains(heights[i]))
                hs.add(heights[i]);
        }
        
        for(int h : hs){
            int size = 0;
            for(int i = 0; i < heights.length; i++){
                if(heights[i] >= h){
                    size += h;
                    sizeMax = Math.max(size, sizeMax);
                }
                else{
                    size = 0;
                }
            }
        }
        
        return sizeMax;   
    }
    
    public int largestRectangleArea3(int[] heights) {

        PriorityQueue<Integer> pActive = new PriorityQueue<Integer>(Collections.reverseOrder());
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        int maxArea = 0;
        
        for(int i = 0; i < heights.length; i++){
            int back = 0;
            
            while(!pActive.isEmpty() && pActive.peek() > heights[i]){
                int h = pActive.poll();
                int w = i - m.get(h);
                maxArea = Math.max(maxArea, h * w);
                back = w;
            }
            if(pActive.isEmpty() || pActive.peek() < heights[i]){
                pActive.add(heights[i]);
                m.put(heights[i], i - back);
            }
        }
        
        while(!pActive.isEmpty()){
            int h = pActive.poll();
            int w = heights.length - m.get(h);
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }
}
