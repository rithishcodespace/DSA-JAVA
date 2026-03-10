class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        HashMap<Integer,Integer> hmap = new HashMap<>();
        ListNode curr = head;
        while(curr != null){
            hmap.put(curr.val,hmap.getOrDefault(curr.val,0)+1);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        curr = head;
        while(curr != null){
            if(hmap.get(curr.val) == 1){
                tail.next = curr;
                tail = tail.next;
            }
            curr = curr.next;
        }

        tail.next = null;

        return dummy.next;
    }
}