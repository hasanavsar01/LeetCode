package problems.hard.p0218;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// 218. The Skyline Problem

	}

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        HashSet<Integer> uniqueX = new HashSet<Integer>();
        PriorityQueue<Integer> pX = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pHeights = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        HashMap<Integer, List<Integer>> mAdd = new HashMap<Integer, List<Integer>>();
        
        HashMap<Integer, List<Integer>> mRemove = new HashMap<Integer, List<Integer>>();
       
        for(int i = 0; i < buildings.length; i++){
            
            if(!uniqueX.contains(buildings[i][0])){
                uniqueX.add(buildings[i][0]);
                pX.add(buildings[i][0]);
            }
            
            if(!mAdd.containsKey(buildings[i][0]))
                mAdd.put(buildings[i][0], new ArrayList<Integer>());
           
            mAdd.get(buildings[i][0]).add(buildings[i][2]);
            
            if(!uniqueX.contains(buildings[i][1])){
                uniqueX.add(buildings[i][1]);
                pX.add(buildings[i][1]);
            }
            
            if(!mRemove.containsKey(buildings[i][1]))
                mRemove.put(buildings[i][1], new ArrayList<Integer>());
           
            mRemove.get(buildings[i][1]).add(buildings[i][2]);
        }
        
        int h = 0;
        
        while(pX.size() > 0){
            if(mAdd.containsKey(pX.peek())){
                for(int height : mAdd.get(pX.peek())){
                    pHeights.add(height);
                }
            }
            if(mRemove.containsKey(pX.peek())){
                for(int height : mRemove.get(pX.peek())){
                    pHeights.remove(height);
                }
            }
            
            int newX = pX.poll();
            int newH = pHeights.size() == 0 ? 0 : pHeights.peek();
            
            if(newH == h) continue;
            
            h = newH;
            
            ArrayList<Integer> temp = new ArrayList();
            temp.add(newX);
            temp.add(newH);
            result.add(temp);
        }
       
        return result;
    }

}
