package problems.easy.p0021;

import problems.*;

public class Solution {

	public static void main(String[] args) {
		// 21. Merge Two Sorted Lists

	}

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode small = l1.val <  l2.val ? l1 : l2;
        ListNode big   = l1.val >= l2.val ? l1 : l2;
        ListNode head  = small;
        
        while(big != null){
            while(small.next != null && small.next.val <= big.val)
                small = small.next;
            
            ListNode temp = small.next;
            small.next = big;
            big = temp;
        }
        
        return head;
    }
}
