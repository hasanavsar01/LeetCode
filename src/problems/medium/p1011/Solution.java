package problems.medium.p1011;

public class Solution {

	public static void main(String[] args) {
		// TODO Capacity To Ship Packages Within D Days

	}

    public static int shipWithinDays(int[] weights, int D) {
        int max = 0;
        for(int n : weights)
            max = Math.max(max, n);
        
        while(true){
            int sum = 0;
            int days = 1;
            for(int i = 0; i < weights.length; i++){
                if(sum + weights[i] > max){
                    if(++days > D){
                        max++;
                        break;
                    }
                        
                    sum = weights[i];
                }
                else{
                    sum += weights[i];
                }
            }
            
            if(days == D || (days < D && weights.length >= D))
                break;
        }
        return max;
    }
}
