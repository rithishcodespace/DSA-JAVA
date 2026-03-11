class Solution {
    long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        pre_order(root);
        return (min2 == Long.MAX_VALUE) ? -1 : (int)min2;     
    }
    public void pre_order(TreeNode root){
        if(root == null)return;

        pre_order(root.left);

        if(root.val < min1){
            min2 = min1;
            min1 = root.val;
        }
        else if(root.val > min1 && root.val < min2){
            min2 = root.val;
        }

        pre_order(root.right);
    }
}