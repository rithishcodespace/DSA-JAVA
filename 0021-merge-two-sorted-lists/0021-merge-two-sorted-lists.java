// O(n)
// O(1)

class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode ans = dummy;
                
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                dummy.next = head1;
                dummy = head1;

                head1 = head1.next;
            }
            else{
                dummy.next = head2;
                dummy = head2;

                head2 = head2.next;
            }
        }

        if(head1 != null){
            dummy.next = head1;
        }
        else if(head2 != null){
            dummy.next = head2;
        }

        return ans.next;
    }
}