// tc: O(n) (since i used map)
// sc: O(h)

class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return constructTree(0, inorder.length-1, 0, preorder.length-1, inorder, preorder);
    }
    public TreeNode constructTree(int in_l, int in_r, int pre_l, int pre_r, int[] inorder, int[] preorder){
        if(in_l > in_r || pre_l > pre_r)return null;

        // create root
        TreeNode root = new TreeNode(preorder[pre_l]);

        // find root nodes index in inorder array
        int idx = map.get(root.val);

        int diff = (idx-in_l);

        // call next call based on the computed idx [left part] idx [right part]
        root.left = constructTree(in_l, idx-1, pre_l+1, pre_l+diff, inorder, preorder);
        root.right = constructTree(idx+1, in_r, pre_l+diff+1, pre_r, inorder, preorder);

        return root;
    }
}