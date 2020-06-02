package problems.medium.p0138;

import java.util.*;
import problems.*;

public class Solution {

	public static void main(String[] args) {
		// 138. Copy List with Random Pointer

	}

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        List<Node> list = new ArrayList();
        Map<Node, Integer> map = new HashMap();
        
        while(head != null){
            list.add(head);
            map.put(head, list.size() - 1);
            head = head.next;
        }
        
        List<Node> newList = new ArrayList();
        
        for(int i = 0; i < list.size(); i++){
            newList.add(new Node(list.get(i).val));
        }
        
        for(int i = 0; i < newList.size(); i++){
            if(i < list.size() - 1)
                newList.get(i).next = newList.get(i + 1);
        }
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).random != null)
                newList.get(i).random = newList.get(map.get(list.get(i).random));
        }
        
        return newList.get(0);
    }
}
