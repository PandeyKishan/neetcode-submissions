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
        if(lists == null || lists.length == 0)
            return null;
        int n = lists.length;
        int interval = 1;

        while(interval < n) {
            for(int i = 0; i + interval < n; i += interval * 2) {
                lists[i] = mergeLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        while(ptr1 != null && ptr2 != null) {
            if(ptr1.val <= ptr2.val) {
                curr.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                curr.next = ptr2;
                ptr2 = ptr2.next;
            }
            curr = curr.next;
        }

        if(ptr1 != null) {
            curr.next = ptr1;
            ptr1 = ptr1.next;
            curr = curr.next;
        } else {
            curr.next = ptr2;
            ptr2 = ptr2.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
