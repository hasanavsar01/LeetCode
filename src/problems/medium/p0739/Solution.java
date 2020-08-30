package problems.medium.p0739;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 739. Daily Temperatures

	}
	
	public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        
        int[] output = new int[T.length];
        
        for(int i = T.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && T[stack.peek()] <= T[i])
                stack.pop();
            
            output[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            
            stack.push(i);
        }
        
        return output;
    }
}
