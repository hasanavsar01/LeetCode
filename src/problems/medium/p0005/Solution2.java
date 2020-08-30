package problems.medium.p0005;

public class Solution2 {

	public static void main(String[] args) {
		// 5. Longest Palindromic Substring

	}
	
    public static String longestPalindrome(String s) {
        if(s.isEmpty())
            return "";
        
        int left = 0;
        int right = 1;
        
        char[] str = s.toCharArray();
        
        for(int i = 0; i < str.length; i++){
            int l = i - 1;
            int r = i + 1;
            
            while(l >= 0 && r < str.length){
                if(str[l] == str[r]){
                    if(r - l + 1 > right - left){
                        right = r + 1;
                        left = l;
                    }
                    r++;
                    l--;
                }
                else
                    break;
            }
            
            l = i;
            r = i + 1;
            
            while(l >= 0 && r < str.length){
                if(str[l] == str[r]){
                    if(r - l + 1 > right - left){
                        right = r + 1;
                        left = l;
                    }
                    r++;
                    l--;
                }
                else
                    break;
            }
        }
        
        return s.substring(left, right);
    }
}
