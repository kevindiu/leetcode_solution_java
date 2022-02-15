// https://leetcode.com/problems/two-sum/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int diff = target - n;
            Integer idx = diffMap.get(n);
            if (idx != null) {
                return new int[] {i, idx};
            }
            diffMap.put(diff, i);
        }
        
        return null;
    }
}
