package problems.medium.p0006;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 6. ZigZag Conversion

	}
	
	public String convert(String s, int numRows) {
        if(numRows >= s.length()) return s;
        if(numRows <= 1) return s;
        
        LinkedList<Character>[] q = new LinkedList[numRows];
        boolean isDown = true;
        
        char[] chars = s.toCharArray();
        
        int sIndex = 0;
        int rotator = 0;
        
        for(int i = 0; i < chars.length; i++){
            if(q[sIndex] == null) q[sIndex] = new LinkedList();
            q[sIndex].add(chars[i]);
            rotator++;
            
            if(rotator == numRows)
                isDown = false;
            if(rotator == 2 * numRows - 1){
                isDown = true;
                rotator = 1;
            }
            
            if(isDown) sIndex++;
            else sIndex--;
        }
        
        sIndex = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(!q[sIndex].isEmpty()){
            sb.append(q[sIndex].poll());
            
            if(q[sIndex].isEmpty() && sIndex < q.length - 1)
                sIndex++;
        }
        
        return sb.toString();
    }

}
