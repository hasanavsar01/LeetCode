package problems.medium.p0146;

import java.util.*;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node node = map.get(key);
        
        carryTop(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            carryTop(map.get(key));
            return;
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        
        node.prev = tail.prev;
        tail.prev.next = node;
        
        node.next = tail;
        tail.prev = node;
        
        if(map.size() > capacity){
            Node rem = map.get(head.next.key);
            map.remove(head.next.key);
            
            head.next = head.next.next;
            head.next.prev = head;
            
            rem.prev = null;
            rem.next = null;
        }
    }
    
    public void carryTop(Node node){
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        node.prev = tail.prev;
        tail.prev.next = node;
        
        node.next = tail;
        tail.prev = node;
    }
}