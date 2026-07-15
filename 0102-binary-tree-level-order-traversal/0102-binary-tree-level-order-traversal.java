// tc: O(n)
// sc: O(n)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bfs = new ArrayList<>();
        if(root == null)return bfs;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
            }
            bfs.add(list);
        }        

        return bfs;
    }
}