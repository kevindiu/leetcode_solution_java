// https://leetcode.com/problems/word-search-ii/submissions/
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        for (String w : words) {
            if (findWord(board, w, 0, 0, 0, new HashSet<Pair<Integer, Integer>>())) {
                result.add(w);
            }
        }
        
        return result;
    }
    
    private boolean findWord(char[][] b, String w, int x, int y, int wi, Set<Pair<Integer, Integer>> visited) {
        if (wi == w.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= b.length || y >= b[x].length) {
            return false;
        }
        
        Pair<Integer, Integer> p = new Pair<Integer, Integer>(x, y);
        if (visited.contains(p)) {
            return false;
        }
        
        if (b[x][y] == w.charAt(wi)) {
            visited.add(p);
            if (findWord(b, w, x, y+1, wi+1, visited)) {
                return true;
            }
            if (findWord(b, w, x, y-1, wi+1, visited)) {
                return true;
            }
            if (findWord(b, w, x+1, y, wi+1, visited)) {
                return true;
            }
            if (findWord(b, w, x-1, y, wi+1, visited)) {
                return true;
            }
            visited.remove(p);
        }
        if (visited.size() == 0) {
            if (findWord(b, w, x+1, y, wi, visited)) {
                return true;
            }
            if (findWord(b, w, x, y+1, wi, visited)) {
                return true;
            }
        }
        
        return false;
    }
}
