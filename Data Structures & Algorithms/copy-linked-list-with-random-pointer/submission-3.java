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
        if (head == null) 
            return null;
        Node ptr = head;

        // Step 1: Insert copied nodes
        while(ptr != null) {
            Node clone = new Node(ptr.val);
            clone.next = ptr.next;
            ptr.next = clone;
            ptr = clone.next;
        }

        ptr = head;

        // Step 2: Set random pointers
        while(ptr != null) {
            if(ptr.random != null) {
                ptr.next.random = ptr.random.next;
            }    
            ptr = ptr.next.next;
        }

        // A A' B B' C C'

        ptr = head;
        Node clonedHead = head.next;

        // Step 3: Separate the lists
        while(ptr != null) {
            Node clone = ptr.next;
            ptr.next = clone.next;
            if(clone.next != null)
                clone.next = clone.next.next;
            ptr = ptr.next;    
        }

        return clonedHead;
    }
}
