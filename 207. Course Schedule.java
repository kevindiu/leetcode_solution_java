// https://leetcode.com/problems/course-schedule/submissions/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> premap = new HashMap<>();
        for (int[] req : prerequisites) {
            List<Integer> preList = null;
            preList = premap.get(req[0]);
            
            if (preList == null) {
                preList = new LinkedList<>();
                premap.put(req[0], preList);
            }
            preList.add(req[1]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, premap, visited)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int cur, Map<Integer, List<Integer>> preReqs, Set<Integer> visited) {
        if (visited.contains(cur)) {
            return false;
        }
        List<Integer> pre = preReqs.get(cur);
        if (pre == null || pre.size() == 0) {
            return true;
        }
        
        visited.add(cur);
        if (pre != null) {
            for (Integer preq : pre) {
               if (!dfs(preq, preReqs, visited)) {
                   return false;
              }
             }
        }
        visited.remove(cur);
        preReqs.put(cur, null);
        return true;
    }
}
