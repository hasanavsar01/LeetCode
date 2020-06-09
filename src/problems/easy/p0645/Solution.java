package problems.easy.p0645;

public class Solution {

	public static void main(String[] args) {
		// 645. Set Mismatch

	}

    public int[] findErrorNums(int[] nums) {
        int[] counts = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            counts[nums[i] - 1]++;
        }
        
        int twice = 0;
        int missing = 0;
        
        for(int i = 0; i < counts.length; i++){
            if(counts[i] == 2)
                twice = i + 1;
            if(counts[i] == 0)
                missing = i + 1;
        }
        return new int[] {twice, missing};
    }
}
