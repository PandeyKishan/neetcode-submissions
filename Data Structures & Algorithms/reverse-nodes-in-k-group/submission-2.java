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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1)
            return head;
        ListNode ptr = head;
        int totalNodes = 0;

        while(ptr != null) {
            ptr = ptr.next;
            totalNodes++;
        }

        int partitions = totalNodes / k;

        ptr = head;
        ListNode newHead = null;
        ListNode previousGroupTail = null;

        while(partitions > 0) {
            int count = k;
            ListNode currentGroupTail = ptr;
            ListNode prev = null;

            while(count > 0) {
                ListNode temp = ptr.next;
                ptr.next = prev;
                prev = ptr;
                ptr = temp;
                count--;
            }

            if(newHead == null)
                newHead = prev;

            if(previousGroupTail != null) 
                previousGroupTail.next = prev;
            
            previousGroupTail = currentGroupTail;
            partitions--;
        }

        if (previousGroupTail != null) 
            previousGroupTail.next = ptr;
        
        return newHead;
    }
}
