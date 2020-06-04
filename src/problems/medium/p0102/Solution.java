package problems.medium.p0102;

import java.util.*;
import problems.*;

public class Solution {

	public static void main(String[] args) {
		// 102. Binary Tree Level Order Traversal

	}

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        q1.add(root);
        q2.add(1);
        
        while(!q1.isEmpty()){
            TreeNode currNode = q1.poll();
            int currIndex = q2.poll();
            
            if(result.size() < currIndex)
                result.add(new ArrayList<>());
            
            result.get(result.size() - 1).add(currNode.val);
            
            if(currNode.left != null){
                q1.add(currNode.left);
                q2.add(currIndex + 1);
            }
            
            if(currNode.right != null){
                q1.add(currNode.right);
                q2.add(currIndex + 1);
            }
        }
        return result;
    }
}
