// https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int maxLeft = height[0];
        int maxRight = height[right];
        
        int result = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
            }
        }
        
        return result;
    }
}
