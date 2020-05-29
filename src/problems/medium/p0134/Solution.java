package problems.medium.p0134;

public class Solution {

	public static void main(String[] args) {
		// 134. Gas Station

	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            int tank = 0;
            int count = 0;
            for(int j = i; j < i + gas.length; j++){
                tank += gas[j % gas.length] - cost[j % gas.length];
                if(tank < 0)
                    break;
                count++;
            }
            if(count == gas.length)
                return i;
        }
        return -1;
    }
    
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int cur = 0;  //cur diff
        int total = 0; //total diff
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
            
            total += gas[i] - cost[i];
        }
        
        return total >= 0 ? start : -1;
    }

}
