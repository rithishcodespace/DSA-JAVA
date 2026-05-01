class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);

        ListNode curr = head;
        int carry = 0;

        while(curr != null){
            int val = curr.val * 2 + carry;
            curr.val = val%10;
            carry = val/10;

            if(curr.next == null){
                break;
            }

            curr = curr.next;
        }   

        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return reverse(head);     
    }
    public ListNode reverse(ListNode curr){
        ListNode prev = null;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}