package problems.hard.p0295;

import java.util.*;

public class MedianFinder {
    Queue<Integer> minheap;
    Queue<Integer> maxheap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minheap = new PriorityQueue<Integer>();
        maxheap = new PriorityQueue<Integer>((x, y) -> y - x);
    }
    
    public void addNum(int num) {
        maxheap.offer(num);
        if(maxheap.size() > minheap.size() + 1)
            minheap.offer(maxheap.poll());
        
        /* Bu swap iþlemi çok önemli*/
        if(!minheap.isEmpty() && maxheap.peek() > minheap.peek()){
            int temp = maxheap.poll();
            maxheap.offer(minheap.poll());
            minheap.offer(temp);
        }
    }
    
    public double findMedian() {
        if(maxheap.isEmpty())
            return 0;
        
        if(maxheap.size() > minheap.size())
            return (double)maxheap.peek();
        
        double d = minheap.peek() + maxheap.peek();
        return d / 2;
    }
}