// https://leetcode.com/problems/concatenation-of-array/submissions/
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[2*nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = nums[i];
            result[nums.length+i] = nums[i];
        }
        return result;
    }
}
