package problems.medium.p1008;

import java.util.*;

import problems.TreeNode;
import problems.medium.*;

public class Solution {

	public static void main(String[] args) {
		// 1008. Construct Binary Search Tree from Preorder Traversal

	}
	
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode root = new TreeNode(preorder[0]);
        
        s.push(root);
        
        for(int i = 1; i < preorder.length; i++){
            TreeNode current = s.peek();
            
            if(preorder[i] < current.val){
                current.left = new TreeNode(preorder[i]);
                s.push(current.left);
            }
            else{
                while(!s.isEmpty() && s.peek().val < preorder[i])
                    current = s.pop();
                
                current.right = new TreeNode(preorder[i]);
                s.push(current.right);
            }
        }
        
        return root;
    }

}
