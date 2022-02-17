// https://leetcode.com/problems/clone-graph/submissions/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return clone(node, visited);
    }
    
    private Node clone(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        
        for (Node n : node.neighbors) {
            clonedNode.neighbors.add(clone(n, visited));
        }
        
        
        
        return clonedNode;
    }
}
