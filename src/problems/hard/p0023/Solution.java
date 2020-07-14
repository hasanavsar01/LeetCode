package problems.hard.p0023;

import java.util.*;

import problems.ListNode;

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

    // Better approach
    public ListNode mergeKLists2(ListNode[] lists) {
        
        Queue<ListNode> pq = new PriorityQueue<ListNode>(
            new Comparator<ListNode>(){
                public int compare(ListNode l1, ListNode l2){
                    return l1.val - l2.val;
                }
            }
        );
        
        for(ListNode node : lists){
            while(node != null){
                pq.add(node);
                node = node.next;
            }
        }
        
        if(pq.isEmpty())
            return null;
        
        ListNode head = pq.poll();
        ListNode temp = head;
        
        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;
        }
        temp.next = null;
        
        return head;
    }
}
