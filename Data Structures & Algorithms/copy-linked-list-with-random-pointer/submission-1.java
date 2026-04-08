/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Solution - 1
        // if(head == null) return null;
        // Node curr = head;
        // while(curr != null){
        //     Node copy = new Node(curr.val);
        //     copy.next = curr.next;
        //     curr.next = copy;
        //     curr = copy.next;
        // }
        // curr = head;
        // while(curr != null){
        //     if(curr.random != null){
        //         curr.next.random = curr.random.next;
        //     }
        //     curr = curr.next.next;
        // }
        // Node dummy = new Node(0);
        // Node copyCurr = dummy;
        // curr = head;
        // while(curr != null){
        //     copyCurr.next = curr.next;
        //     curr.next = curr.next.next;

        //     copyCurr = copyCurr.next;
        //     curr = curr.next;
        // }
        // return dummy.next;
        // Solution - 2
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            oldToCopy.put(curr, copy);
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            Node copy = oldToCopy.get(curr);
            copy.next = oldToCopy.get(curr.next);
            copy.random = oldToCopy.get(curr.random);
            curr = curr.next;
        }
        return oldToCopy.get(head);
    }
}
