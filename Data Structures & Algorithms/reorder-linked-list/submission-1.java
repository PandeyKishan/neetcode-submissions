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
    public void reorderList(ListNode head) {
        // if (head == null || head.next == null)
        //     return;

        // List<Integer> values = new ArrayList<>();

        // ListNode ptr1 = head;

        // while (ptr1 != null) {
        //     values.add(ptr1.val);
        //     ptr1 = ptr1.next;
        // }

        // int left = 0, right = values.size() - 1;

        // ListNode reorder = new ListNode(0);
        // ListNode ptr2 = reorder;

        // while (left < right) {
        //     ptr2.next = new ListNode(values.get(left));
        //     ptr2 = ptr2.next;

        //     ptr2.next = new ListNode(values.get(right));
        //     ptr2 = ptr2.next;

        //     left++;
        //     right--;
        // }

        // // Add the middle node for odd-length lists
        // if (left == right) {
        //     ptr2.next = new ListNode(values.get(left));
        // }

        // // Copy values back into the original list
        // ptr1 = head;
        // ptr2 = reorder.next;

        // while (ptr1 != null) {
        //     ptr1.val = ptr2.val;
        //     ptr1 = ptr1.next;
        //     ptr2 = ptr2.next;
        // }

        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        slow.next = null;

        ListNode prev = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head;
        ListNode second = prev;

        while(second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }    
    }
}
