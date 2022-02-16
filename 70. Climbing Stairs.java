// https://leetcode.com/problems/climbing-stairs/submissions/
class Solution {
    private Map<Integer, Integer> dp = new HashMap<>();
    
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        Integer r = dp.get(n);
        if (r != null) {
            return r;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int steps = climbStairs(n - 1) + climbStairs(n-2);
        dp.put(n, steps);
        return steps;
    }
}
