// https://leetcode.com/problems/distinct-subsequences/submissions/
class Solution {
    public int numDistinct(String s, String t) {
        return dp(s, t, 0, 0, new HashMap<String, Integer>());
    }
    
    private int dp(String s, String t, int si, int ti, Map<String, Integer> r) {
        Integer b = r.get(key(si, ti));
        if (b != null) {
            return b;
        }
        if (ti >= t.length()) {
            return 1;
        }
        
        if (si >= s.length()) {
            return 0;
        }
        
        int i = 0;
        if (s.charAt(si) == t.charAt(ti)) {
            i = dp(s, t, si+1, ti+1, r);
        }
        
        i = i + dp(s, t, si+1, ti, r);
        
        r.put(key(si, ti), i);
        
        return i;
    }
    
    private String key(int i1, int t1) {
        return i1 + " " + t1;
    }
}
