// https://leetcode.com/problems/count-and-say/submissions/
class Solution {
    public String countAndSay(int n) {
        return dp(n);
    }
    
    private String dp(int n) {
        if (n == 1) {
            return "1";
        }
        
        String s = dp(n-1);
        StringBuilder result = new StringBuilder();
        
        int cn = s.charAt(0) - '0';
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            int v = s.charAt(i) - '0';
            if (v == cn) {
                cnt++;
            } else {
                result.append(cnt);
                result.append(cn);
                
                cn = v;
                cnt = 1;
            }
        }
        result.append(cnt);
        result.append(cn);
        return result.toString();
    }
}
