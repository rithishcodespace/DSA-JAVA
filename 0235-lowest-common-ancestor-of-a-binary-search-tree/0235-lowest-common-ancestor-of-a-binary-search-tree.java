class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postorder(root, p, q);
        return lca;
    }
    public boolean postorder(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)return false;

        boolean left = postorder(root.left, p, q);
        boolean right = postorder(root.right, p, q);

        if(left && right){ // case 1 - 3 nodes
            if(lca == null)lca = root;
        }
        else if((left || right) && (root.val == p.val || root.val == q.val)){ // case 2 - only 2 nodes
            if(lca == null)lca = root;
        }

        return (root.val == p.val || root.val == q.val) || (left || right);
    }
}