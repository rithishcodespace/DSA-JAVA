// fast and slow pointers

class Solution {
    public void reorderList(ListNode head) {
        // reach the first half
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half
        ListNode curr = slow.next, prev = null;
        slow.next = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // connect nodes from two linkedlist -> first and second half
        ListNode head1 = head;
        ListNode head2 = prev;

        while(head1 != null && head2 != null){
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }
}