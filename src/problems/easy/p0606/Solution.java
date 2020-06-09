package problems.easy.p0606;

import problems.*;

public class Solution {

	public static void main(String[] args) {
		// 606. Construct String from Binary Tree

	}
	
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        if(t.left == null && t.right == null)
            return Integer.toString(t.val);
        if(t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

}
