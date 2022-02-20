// https://leetcode.com/problems/maximum-subarray/submissions/
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count = Math.max(nums[i], count + nums[i]);
            max = Math.max(count, max);
        }
        return max;
    }
}
