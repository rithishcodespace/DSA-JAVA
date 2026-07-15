// tc: O(n)
// sc: O(tree height)

// do my children contain p and q ?

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

        if(left && right){
            if(lca == null)lca = root; // case 1
        }
        else if((left || right) && (root.val == p.val || root.val == q.val)){
            lca = root; // case 2
        }

        return (root.val == p.val || root.val == q.val) || (left || right);
    }
}