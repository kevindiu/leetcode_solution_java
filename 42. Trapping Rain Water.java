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
                result += water(maxLeft, maxRight, height[left]);
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                right--;
                result += water(maxLeft, maxRight, height[right]);
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        
        return result;
    }
    
    private int water(int maxLeft, int maxRight, int h) {
        int water = Math.min(maxLeft, maxRight) - h;
        if (water > 0) {
            return water;
        }
        return 0;
    }
}
