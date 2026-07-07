// since the list is stored in reversed order, dont wont worry about diff lengths
// sum it, pass the carry to right, not to left

// tc: O(n)
// sc: O(max(n, m))

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode ans = dummy;
        while(l1 != null || l2 != null){
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            int sum = num1 + num2 + carry;

            int digit = sum%10;

            if(sum >= 10)carry = sum / 10;
            else carry = 0;

            dummy.next = new ListNode(digit);
            dummy = dummy.next;

            if(l1 != null)l1 = l1.next;
            if(l2 != null)l2 = l2.next;
        }

        if(carry > 0){
            dummy.next = new ListNode(carry);
            dummy = dummy.next;
        }

        return ans.next;
    }
}