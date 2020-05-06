package problems.hard.p0023;

import java.util.*;
import problems.hard.ListNode;

public class Solution {

	public static void main(String[] args) {
		// 23. Merge k Sorted Lists

	}
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> q = new PriorityQueue();
        
        for(int i = 0; i < lists.length; i++){
            while(lists[i] != null){
                q.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        
        if(q.size()  == 0)
            return null;
        
        ListNode result = new ListNode(q.poll());
        ListNode current = result;
        
        while(q.size() > 0){
            current.next = new ListNode(q.poll());
            current = current.next;
        }
        
        return result;
    }

}
