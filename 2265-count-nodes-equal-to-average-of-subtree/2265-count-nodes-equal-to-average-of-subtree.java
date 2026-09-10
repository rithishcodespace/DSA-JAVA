// post-order

class Solution {

    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        postorder(root);
        return count;
    }

    public int[] postorder(TreeNode root){
        if(root == null)return new int[]{0,0};

        int[] left = postorder(root.left);
        int[] right = postorder(root.right);

        int sum = left[0]+right[0]+root.val;
        int n = left[1]+right[1]+1;

        if(sum/n == root.val)count++;

        return new int[]{sum, n};
    }
}