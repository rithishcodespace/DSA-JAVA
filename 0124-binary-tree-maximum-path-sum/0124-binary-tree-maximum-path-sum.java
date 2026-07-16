// each node contains the sum of their Max child + them
// if sum reaches neg, update max, start from 0 again

// a path is like a straight road, that cannot branch

// tc: O(n)
// sc: O(tree height)

class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postorder(root);
        return max;
    }

    public int postorder(TreeNode root){
        if(root == null)return 0;

        int left = postorder(root.left);
        int right = postorder(root.right);

        max = Math.max(max, root.val + left + right); // a single root, can pick both left and right

        return root.val+Math.max(left, right) > 0 ? root.val+Math.max(left, right) : 0;
    }
}