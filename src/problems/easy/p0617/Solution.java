package problems.easy.p0617;

import problems.*;

public class Solution {

	public static void main(String[] args) {
		// 617. Merge Two Binary Trees

	}

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode root = new TreeNode();
        
        func(root, t1, t2);
        
        return root;
    }
    
    public void func(TreeNode current, TreeNode t1, TreeNode t2){
        
        current.val = t1.val + t2.val;
        
        if(t1.left == null)
            current.left = t2.left;
        else if(t2.left == null)
            current.left = t1.left;
        else{
            current.left = new TreeNode();
            func(current.left, t1.left, t2.left);
        }
        
        
        if(t1.right == null)
            current.right = t2.right;
        else if(t2.right == null)
            current.right = t1.right;
        else{
            current.right = new TreeNode();
            func(current.right, t1.right, t2.right);
        }
    }
}
