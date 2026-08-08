// I HAVE NOT DONE IT IN LINKEDLIST LIST IMPLEMENTATION, JUST NORMAL ARRAY IMPLEMENTATION

class Solution {
    public ListNode insertionSortList(ListNode head) {
        // extract the integers
        List<Integer> list = new ArrayList<>();

        ListNode curr = head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }

        // insertion sort
        for(int i=1;i<list.size();i++){
            int key = list.get(i);

            int j = i-1;

            while(j >= 0 && list.get(j) > key){
                list.set(j+1, list.get(j));
                j--;
            }

            list.set(j+1, key);
        }

        // convert back to linkedlist
        ListNode dummy = new ListNode(-1);
        ListNode h = dummy;

        for(int i=0;i<list.size();i++){
            h.next = new ListNode(list.get(i));
            h = h.next;
        }

        return dummy.next;
    }
}