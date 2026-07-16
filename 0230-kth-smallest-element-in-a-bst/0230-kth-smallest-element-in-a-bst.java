// tc: O(n)
// sc: O(tree height)

class Solution {
    int ans = 0, cnt=0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);    
        return ans;    
    }

    public void inorder(TreeNode root, int k){
        if(root == null)return;

        inorder(root.left, k);

        cnt++;
        if(cnt == k){
            ans = root.val;
            return;
        }

        inorder(root.right, k);
    }
}