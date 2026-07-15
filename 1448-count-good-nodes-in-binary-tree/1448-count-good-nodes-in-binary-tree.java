class Solution {
    public int goodNodes(TreeNode root) {
        return preorder(root, root.val);        
    }
    public int preorder(TreeNode root, int max){
        if(root == null)return 0;

        int isGood = (root.val >= max) ? 1 : 0;

        int left = preorder(root.left, Math.max(max, root.val));
        int right = preorder(root.right, Math.max(max, root.val));

        return isGood + left + right;
    }
}