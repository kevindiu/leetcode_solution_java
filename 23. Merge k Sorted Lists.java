// https://leetcode.com/problems/merge-k-sorted-lists/submissions/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // find the first element
        int idx = min(lists);
        if (idx == -1) {
            return null;
        }
        ListNode start = lists[idx];
        ListNode cur = lists[idx];
        lists[idx] = lists[idx].next;
        
        idx = min(lists);
        while(idx != -1) {
            cur.next = lists[idx];
            cur = cur.next;
            lists[idx] = lists[idx].next;
            
            idx = min(lists);
        }
        
        return start;
    }
    
    private int min(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode l = lists[i];
            if (l == null) {
                continue;
            }   
            
            if (l.val < min) {
                min = l.val;
                idx = i;
            }
        }
        
        return idx;
    }
}
