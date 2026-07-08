// heap sort

// Time Complexity: O(N log N)
// Space Complexity: O(N)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode ans = dummy;

        // heapify
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });

        for(ListNode head : lists){
            while(head != null){
                minHeap.add(head);
                head = head.next;
            }
        }

        // pop
        while(!minHeap.isEmpty()){
            dummy.next = minHeap.poll();
            dummy = dummy.next;

            dummy.next = null; //break existing connections via question
        }

        return ans.next;
    }
}