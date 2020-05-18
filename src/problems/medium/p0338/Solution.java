package problems.medium.p0338;

public class Solution {

	public static void main(String[] args) {
		// 338. Counting Bits

	}

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        
        for(int i = 0; i < result.length; i++){
            if(i % 2 == 1)
                result[i]++;
            result[i] += result[i >> 1];
        }
        
        return result;
    }
}
