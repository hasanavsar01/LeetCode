package problems.medium.p0337;

import problems.medium.*;

public class Solution {

	public static void main(String[] args) {
		// 337. House Robber III

	}
	
    public int rob(TreeNode root) {
        int[] n = new int[3];
        
        func(root, n);
        
        return n[1] > n[2] ? n[1] : n[2];
    }
    
    public void func(TreeNode current, int[] n){
        if(current == null) return;
        
        int[] nLeft = new int[3];
        func(current.left, nLeft);
        
        int[] nRight = new int[3];
        func(current.right, nRight);
        
        int temp = current.val 
            + (nLeft[0] > nLeft[1] ? nLeft[0] : nLeft[1])
            + (nRight[0] > nRight[1] ? nRight[0] : nRight[1]);
        
        n[0] = nLeft[1] + nRight[1];
        n[1] = Math.max(nLeft[2] + nRight[2], Math.max(nLeft[2] + nRight[1], nLeft[1] + nRight[2]));
        n[2] = temp;
    }

}
