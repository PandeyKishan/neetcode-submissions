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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        ListNode merged = new ListNode();
        ListNode ptr3 = merged;

        while(ptr1 != null && ptr2 != null) {
            if(ptr1.val <= ptr2.val) {
                ptr3.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                ptr3.next = ptr2;
                ptr2 = ptr2.next;
            }
            ptr3 = ptr3.next;
        }

        while(ptr1 != null) {
            ptr3.next = ptr1;
            ptr1 = ptr1.next;
            ptr3 = ptr3.next;
        }

        while(ptr2 != null) {
            ptr3.next = ptr2;
            ptr2 = ptr2.next;
            ptr3 = ptr3.next;
        }

        return merged.next;
    }
}