// tortoise and hare

// both will me at a point, since distance first increase, after meeting a cycle their distance decreases and eventually reaches 0

// tc: O(n)
// sc: O(1)

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)return false;

        ListNode slow = head, fast = head;

        while(fast  != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)return true;
        }  

        return false;
    }
}