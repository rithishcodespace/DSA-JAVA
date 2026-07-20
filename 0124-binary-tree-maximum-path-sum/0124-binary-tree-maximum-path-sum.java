class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        preorder(root);
        return max;
    }
    public int preorder(TreeNode root){
        if(root == null)return 0;

        int left = Math.max(0,preorder(root.left));
        int right = Math.max(0,preorder(root.right));

        max = Math.max(max, left + root.val + right);

        return root.val + Math.max(left, right);
    }
}