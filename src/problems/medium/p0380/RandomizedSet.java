package problems.medium.p0380;

import java.util.*;

public class RandomizedSet {
    private HashMap<Integer, Integer> m;
    private ArrayList<Integer> list;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        m = new HashMap();
        list = new ArrayList();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(m.containsKey(val))
            return false;
        
        m.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!m.containsKey(val))
            return false;
        
        int index = m.get(val);
        
        if(index == list.size() - 1){
            list.remove(index);
        }
        else{
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            m.put(lastVal, index);
            list.remove(list.size() - 1);
        }
        
        m.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
