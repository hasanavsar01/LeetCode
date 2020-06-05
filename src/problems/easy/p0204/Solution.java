package problems.easy.p0204;

public class Solution {

	public static void main(String[] args) {
		// 204. Count Primes

	}

    public int countPrimes(int n) {
        
        boolean[] nonPrimes = new boolean[n];
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            
            for(int j = 2; i * j < n; j++){
                nonPrimes[i * j] = true;
            }
        }
        
        int count = 0;
        
        for(int i = 2; i < n; i++){
            if(!nonPrimes[i])
                count++;
        }
        
        return count;
    }
}
