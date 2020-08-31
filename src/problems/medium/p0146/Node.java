package problems.medium.p0146;

public class Node{
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(){
        this.next = null;
        this.prev = null;
    }
    
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}