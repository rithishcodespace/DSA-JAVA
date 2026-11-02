// postorder

class Solution {
    public TreeNode invertTree(TreeNode root) {
        return post_order(root);
    }
    public TreeNode post_order(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode left = post_order(root.left);
        TreeNode right = post_order(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}