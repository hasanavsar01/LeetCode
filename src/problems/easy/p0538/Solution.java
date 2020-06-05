package problems.easy.p0538;

import problems.*;

public class Solution {

	public static void main(String[] args) {
		// 538. Convert BST to Greater Tree

	}
	
    public TreeNode convertBST(TreeNode root) {
        func(root, 0);
        return root;
    }
    
    public int func(TreeNode current, int sum){
        if(current == null) return sum;
        
        int right = func(current.right, sum);
        
        current.val += right;
        
        int left = func(current.left, current.val);
        
        return left;
    }

}
