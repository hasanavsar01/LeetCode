package problems.easy.p0206;

import problems.*;

public class Solution {

	public static void main(String[] args) {
		// 206. Reverse Linked List

	}
	
    public ListNode reverseList(ListNode head) {
        
    	//*** Recursive ***//
        //return reverse(null, head);
        
    	
    	//*** Iterative ***//
        ListNode current = head;
        ListNode prev = null;
        
        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            
            prev = current;
            current = temp;
        }
        return prev;
    }
    
    public ListNode reverse(ListNode node1, ListNode node2){
        if(node2 == null){
            return node1;
        }
        ListNode temp = node2.next;
        
        node2.next = node1;
        
        return reverse(node2, temp);
    }

}
