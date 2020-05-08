package problems.hard.p0044;

public class Solution {

	public static void main(String[] args) {
		// 44. Wildcard Matching

	}
	
    public boolean isMatch(String s, String p) {
        boolean[][] m = new boolean[s.length() + 1][p.length() + 1];
        m[0][0] = true;
        
        for(int j = 1; j < p.length() + 1; j++)
            m[0][j] = m[0][j - 1] && p.charAt(j - 1) == '*';
        
        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 1; j < p.length() + 1; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    m[i][j] = m[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*')
                    m[i][j] = m[i - 1][j] || m[i][j - 1];
                else
                    m[i][j] = false;
            }
        }
        
        return m[s.length()][p.length()];
    }
}
