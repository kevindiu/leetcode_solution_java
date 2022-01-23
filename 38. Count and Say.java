// https://leetcode.com/problems/count-and-say/submissions/
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String s = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        
        int cn = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            int v = s.charAt(i);
            if (v == cn) {
                cnt++;
            } else {
                result.append(cnt);
                result.append(cn - '0');
                
                cn = v;
                cnt = 1;
            }
        }
        result.append(cnt);
        result.append(cn - '0');
        
        return result.toString();
    }
}
