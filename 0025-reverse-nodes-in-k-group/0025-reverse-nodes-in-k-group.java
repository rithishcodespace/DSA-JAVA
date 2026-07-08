// find k nodes -> reverse them -> connect it to prev reversed k len group

// TC: O(n)
// SC: O(1)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        int count = 0;
        ListNode ans = null, prevTail = null;
        ListNode curr = head, start = head;

        while (curr != null) {
            count++;

            if (count == k) {
                count = 0;

                ListNode nextGroup = curr.next;

                // Save the old head (it becomes the tail after reversing)
                ListNode oldStart = start;

                // Separate this group
                curr.next = null;

                // Reverse the group
                ListNode reversedHead = reverse(start);

                if (ans == null)ans = reversedHead;

                // Connect previous reversed group
                if (prevTail != null)prevTail.next = reversedHead;

                // Connect current group's tail to next group
                oldStart.next = nextGroup;

                // Update previous tail
                prevTail = oldStart;

                // Move to next group
                start = nextGroup;
                curr = nextGroup;
            } else {
                curr = curr.next;
            }
        }

        // If no group was reversed
        if (ans == null)
            return head;

        return ans;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}