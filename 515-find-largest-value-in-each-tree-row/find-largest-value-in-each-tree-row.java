// level order traversal
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.val > max){
                    max = node.val;
                }
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
            }
            list.add(max);
        }
        return list;
    }
}