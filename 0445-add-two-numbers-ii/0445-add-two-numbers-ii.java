// combined all question i did previously

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = rev(l1);
        l2 = rev(l2);

        return addTwoNumbersI(l1, l2);
    }
    public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
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

        return rev(ans.next);
    }
    public ListNode rev(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }   

        return prev;     
    }
}