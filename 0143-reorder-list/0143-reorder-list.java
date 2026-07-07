// slow and fast pointers

// 1 -> 2 -> null <- 3 <- 4
// 5 -> 6 -> null <- 7 <- 8 <- 9

// tc: O(n)
// sc: O(1)

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)return;

        ListNode slow = head;
        ListNode fast = head;

        // seperate first and second half
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second  half
        ListNode curr = slow.next, prev = null;
        slow.next = null; 
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // iterate from both ends and build the list
        ListNode head1 = head;
        ListNode head2 = prev;

        while(head1 != null && head2 != null){
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head2.next = next1;

            head1 = next1;
            head2 = next2;
        }

        // attach remaining
        if(head2 != null){
            head1.next = head2;
        }
    }
}