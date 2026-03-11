// bfs
class Solution {
    public int deepestLeavesSum(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      int sum = 0;

      while(!queue.isEmpty()){
        int n = queue.size();
        sum = 0;
        for(int i=0;i<n;i++){
            TreeNode node = queue.poll();

            sum += node.val;

            if(node.left != null)queue.add(node.left);
            if(node.right != null)queue.add(node.right);
        }
      }  
      return sum;
    }
}