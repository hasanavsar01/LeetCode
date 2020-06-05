package problems.medium.p0089;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 89. Gray Code

	}

    public List<Integer> grayCode(int n) {        
        List<Integer> result = new ArrayList<>();
        
        result.add(0);
        
        for(int i = 0; i < n; i++){
            
            for(int j = result.size() - 1; j >= 0; j--){
                int next = result.get(j) + (int)Math.pow(2, i);
                result.add(next);
            }
        }
        
        return result;
    }
}
