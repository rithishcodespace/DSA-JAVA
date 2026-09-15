class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return post_order(root).node;
    }
    public Pair post_order(TreeNode root){
        if(root == null)return new Pair(null, 0);

        Pair left = post_order(root.left);
        Pair right = post_order(root.right);

        if(left.depth == right.depth){ // if both subtree length is same, i am the lca
            return new Pair(root, left.depth+1);
        }
        else if(left.depth > right.depth){ // if left subtree is big, left side child is lca
            return new Pair(left.node, left.depth+1);
        }

        return new Pair(right.node, right.depth+1); // if right subtree is big, right side child is lca
    }
}

class Pair{
    TreeNode node;
    int depth;

    Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}