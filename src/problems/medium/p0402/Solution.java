package problems.medium.p0402;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 402. Remove K Digits

	}
	
	public String removeKdigits(String num, int k) {
        int size = num.length();
        
        if(k == size) return "0";
        
        Stack<Character> s = new Stack<Character>();
        
        int counter = 0;
        
        while(counter < size){
            
            while(k > 0 && !s.isEmpty() && s.peek() > num.charAt(counter)){
                s.pop();
                k--;
            }
            
            s.push(num.charAt(counter));
            counter++;
        }
        
        while(k > 0){
            s.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }

}
