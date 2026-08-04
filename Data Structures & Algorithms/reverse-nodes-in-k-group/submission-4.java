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
        // if(head == null || head.next == null || k == 1)
        //     return head;
        // ListNode ptr = head;
        // int totalNodes = 0;

        // while(ptr != null) {
        //     ptr = ptr.next;
        //     totalNodes++;
        // }

        // int partitions = totalNodes / k;

        // ptr = head;
        // ListNode newHead = null;
        // ListNode previousGroupTail = null;

        // while(partitions > 0) {
        //     int count = k;
        //     ListNode currentGroupTail = ptr;
        //     ListNode prev = null;

        //     while(count > 0) {
        //         ListNode temp = ptr.next;
        //         ptr.next = prev;
        //         prev = ptr;
        //         ptr = temp;
        //         count--;
        //     }

        //     if(newHead == null)
        //         newHead = prev;

        //     if(previousGroupTail != null) 
        //         previousGroupTail.next = prev;
            
        //     previousGroupTail = currentGroupTail;
        //     partitions--;
        // }

        // if (previousGroupTail != null) 
        //     previousGroupTail.next = ptr;
        
        // return newHead;
        if (head == null || head.next == null || k == 1) return head;
    
    // Count total nodes
    ListNode ptr = head;
    int totalNodes = 0;
    while (ptr != null) {
        ptr = ptr.next;
        totalNodes++;
    }

    int partitions = totalNodes / k;
    ptr = head;
    
    ListNode dummyHead = new ListNode(0); // Dummy node simplifies tracking the new head
    ListNode tailOfPrevGroup = dummyHead;

    while (partitions > 0) {
        int count = k;
        ListNode groupTail = ptr; // This will become the tail of the current reversed group
        ListNode prev = null;

        // Reverse k nodes
        while (count > 0) {
            ListNode temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
            count--;
        }

        // Link the previous group's tail to the new head of this reversed group
        tailOfPrevGroup.next = prev;
        
        // Update the tail tracker to point to the current group's tail
        tailOfPrevGroup = groupTail;
        
        partitions--;
    }

    // Connect the tail of the last reversed group to any remaining nodes (< k)
    tailOfPrevGroup.next = ptr;

    return dummyHead.next;   
    }
}
