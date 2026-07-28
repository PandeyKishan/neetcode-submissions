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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        int total = 0;

        while(ptr != null) {
            ptr = ptr.next;
            total++;
        }

        int index = total - n;

        if (index == 0) {
            return head.next;
        }

        ptr = head;
        int count = 0;

        while(count < index - 1) {
            ptr = ptr.next;
            count++;
        }

        ptr.next = ptr.next.next;

        return head;        
    }
}
