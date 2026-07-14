// similar to same tree question

// tc: O(n*m)
// sc: O(h1 + h2)

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) { 
        return postorder(root, subRoot);
    }
    public boolean postorder(TreeNode r, TreeNode sr){
        if(r == null)return false;

        boolean left = postorder(r.left, sr);
        boolean right = postorder(r.right, sr);

        if(r.val == sr.val){
            if(isSameTree(r, sr)){
                return true;
            }
        }

        return left || right;
    }
    public boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)return true;
        else if(root1 == null || root2 == null)return false;

        if(root1.val != root2.val)return false;

        boolean left = isSameTree(root1.left, root2.left);
        boolean right = isSameTree(root1.right, root2.right);

        return left && right;
    }
}