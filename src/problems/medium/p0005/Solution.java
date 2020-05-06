package problems.medium.p0005;

public class Solution {

	public static void main(String[] args) {
		// 5. Longest Palindromic Substring

	}
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        
        char c[] = s.toCharArray();
        int l = 0;
        int r = 0;
        
        for(int i = 0; i < c.length; i++){
            int max1 = grow(i, i, c);
            int max2 = grow(i - 1, i, c);
            int max = Math.max(max1, max2);
            
            if(max > r - l){
                l = i - max / 2;
                r = i - max / 2 + max;
            }
        }
        return s.substring(l, r);
    }
    
    public int grow(int l, int r, char[] c){
        int size = 0;
        int maxLen = 1;
        
        while (l >= 0 && r < c.length){
            if(c[l] == c[r]){
                size = r - l + 1;
                maxLen = Math.max(maxLen, size);
                l--;
                r++;
            }
            else{
                break;
            }
        }
        return maxLen;
    }
}
