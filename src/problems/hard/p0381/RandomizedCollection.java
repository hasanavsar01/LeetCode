package problems.hard.p0381;

import java.util.*;

//381. Insert Delete GetRandom O(1) - Duplicates allowed

public class RandomizedCollection {
    private HashMap<Integer, HashSet<Integer>> m;
    private ArrayList<Integer> list;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        m = new HashMap();
        list = new ArrayList();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = false;
        
        if(!m.containsKey(val)){
            m.put(val, new HashSet<Integer>());
            result = true;
        }
        
        list.add(val);
        m.get(val).add(list.size() - 1);
        return result;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!m.containsKey(val))
            return false;
        
        int index = m.get(val).iterator().next();
        
        m.get(val).remove(index);
        
        int lastVal = list.get(list.size() - 1);
        
        m.get(lastVal).add(index);
        m.get(lastVal).remove(list.size() - 1);
        
        list.set(index, lastVal);
        list.remove(list.size() - 1);
        
        if(m.get(val).size() == 0)
            m.remove(val);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
