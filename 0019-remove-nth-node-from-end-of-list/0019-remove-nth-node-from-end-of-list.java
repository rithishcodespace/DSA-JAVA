// fast and slow pointer
// when fast is at n, slow should be at fast-k
// so start slow at 1'st node, fast at k'th node, move both my one move

// tc: O(n)
// sc: O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode slow = head, prev = null;
        ListNode fast = fixPointer(head, k);

        while(fast.next != null){
            // maintains slows -> prev 
            prev = slow;

            slow = slow.next;
            fast = fast.next;

        }
        // corner case
        if(slow == head){
            return (head.next == null) ? null : head.next;
        }

        // remove slow
        prev.next = slow.next;

        return head;
    }
    public ListNode fixPointer(ListNode head, int k){
        for(int i=0;i<k-1;i++){
            head = head.next;
        }
        return head;
    }
}