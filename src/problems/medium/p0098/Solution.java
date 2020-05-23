package problems.medium.p0098;

import java.util.*;
import problems.medium.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// 98. Validate Binary Search Tree

	}
    
    public boolean helper(List<Integer> list, TreeNode current){
        if(current == null) return true;
        
        if(!helper(list, current.left)) return false;
        
        if(!list.isEmpty() && current.val <= list.get(list.size() - 1)) return false;
        
        list.add(current.val);
        
        if(!helper(list, current.right)) return false;

        return true;
    }
}
