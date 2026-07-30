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

        while(ptr != null) {
            Node clone = new Node(ptr.val);
            clone.next = ptr.next;
            ptr.next = clone;
            ptr = clone.next;
        }

        ptr = head;

        while(ptr != null) {
            if(ptr.random != null) {
                ptr.next.random = ptr.random.next;
            }    
            ptr = ptr.next.next;
        }

        // A A' B B' C C'

        ptr = head;
        Node clonedHead = head.next;
        Node clone = clonedHead;

        while(clone.next != null) {
            ptr.next = ptr.next.next;
            clone.next = clone.next.next;

            ptr = ptr.next;
            clone = clone.next;
        }

        ptr.next = null;
        clone.next = null;

        return clonedHead;
    }
}
