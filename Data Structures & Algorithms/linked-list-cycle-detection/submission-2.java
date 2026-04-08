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
    public boolean hasCycle(ListNode head) {
        // Using HashSet
        // HashSet<ListNode> seen = new HashSet<>();
        // ListNode current = head;
        // while(current != null){
        //     if(seen.contains(current)){
        //         return true;
        //     }
        //     seen.add(current);
        //     current = current.next;
        // }
        // return false;

        // Using Slow and fast approach
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
