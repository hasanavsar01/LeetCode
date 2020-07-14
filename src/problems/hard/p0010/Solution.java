package problems.hard.p0010;

public class Solution {

	public static void main(String[] args) {
		// 10. Regular Expression Matching

	}

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
    
    public boolean isMatch2(String s, String p) {
        if(p.isEmpty())
            return s.isEmpty();
        
        if(p.length() > 1 && p.charAt(1) == '*'){
            if(s.isEmpty())
                return isMatch(s, p.substring(2));
            
            if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            
            return isMatch(s, p.substring(2));
        }
        
        if(!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
            return isMatch(s.substring(1), p.substring(1));
        
        return false;
    }
}
