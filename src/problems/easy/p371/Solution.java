package problems.easy.p371;

public class Solution {

	public static void main(String[] args) {
		// 371. Sum of Two Integers

	}

    public int getSum(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
