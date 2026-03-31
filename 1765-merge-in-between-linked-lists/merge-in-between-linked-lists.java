class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int cnt = 0;
        ListNode curr = list1;
        ListNode node1 = null, node2 = null;
        while(curr != null){
            if(cnt == a-1)node1 = curr;
            if(cnt == b+1)node2 = curr;
            cnt++;
            curr = curr.next;
        }        
        node1.next = list2;
        curr = list2;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = node2;
        return list1;
    }
}