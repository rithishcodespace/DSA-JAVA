// compare level of the tree with list size()

// tc: O(n)
// sc: O(tree height)

class Solution {
    List<Integer> rv = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        postorder(root, 0);
        return rv;
    }

    public void postorder(TreeNode root, int level){
        if(root == null)return;

        // adding first time to current level (dummy)
        if(rv.size() <= level) rv.add(-1);

        postorder(root.left, level+1);
        postorder(root.right, level+1);

        // updating the nodes in the same level (last one survives)
        rv.set(level,root.val);
    }
}