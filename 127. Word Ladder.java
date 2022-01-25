// https://leetcode.com/problems/word-ladder/
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int min = dp(beginWord, endWord, wordList, new boolean[wordList.size()], 1);
        if (min >= Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
    
    private int dp(String beginWord, String endWord, List<String> wordList, boolean[] visited, int depth) {  
        int minDepth = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size(); i++) {
            if (visited[i]) {
                continue;
            }
            String word = wordList.get(i);
            
            int diff = diffWord(beginWord, word);
            if (diff == 1) {
                if (endWord.equals(word)) {
                    minDepth = Math.min(minDepth, depth + 1);
                } else {
                    visited[i] = true;
                    minDepth = Math.min(minDepth, dp(word, endWord, wordList, visited, depth + 1));
                    visited[i] = false;
                 }
            }
        }
        
        return minDepth;
    }
    
    private int diffWord(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
