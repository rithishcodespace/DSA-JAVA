// dfs - process every left-right pairs

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);    
        return root;    
    }
    public void dfs(TreeNode left, TreeNode right, int level){
        if(left == null || right == null){
            return;
        }

        // swap
        if(level%2 == 1){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, level+1);
        dfs(left.right, right.left, level+1);
    }
}