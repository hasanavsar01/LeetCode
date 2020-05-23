package problems.medium.p0103;

import problems.medium.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 103. Binary Tree Zigzag Level Order Traversal

	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null) return result;
        
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> list = new ArrayList();
            while(!s1.isEmpty()){
                TreeNode current = s1.pop();
                list.add(current.val);
                
                if(current.left != null) s2.push(current.left);
                if(current.right != null) s2.push(current.right);
            }
            if(!list.isEmpty())
                result.add(list);
            
            
            list = new ArrayList();
            while(!s2.isEmpty()){
                TreeNode current = s2.pop();
                list.add(current.val);
                
                if(current.right != null) s1.push(current.right);
                if(current.left != null) s1.push(current.left);
            }
            if(!list.isEmpty())
                result.add(list);
        }
        
        return result;
    }
}
