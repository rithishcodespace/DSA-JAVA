class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            while(!stack.isEmpty() && stack.peek().val < head.val){
                stack.pop();
            }
            stack.push(head);
            head = head.next;
        }        
        ListNode Dummy = null;

        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            node.next = Dummy;
            Dummy = node;
        }
        return Dummy;
    }
}