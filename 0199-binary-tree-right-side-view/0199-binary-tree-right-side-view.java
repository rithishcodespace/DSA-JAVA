class Solution {

    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        preorder(root, 0);
        return list;
    }

    public void preorder(TreeNode root, int level){
        if(root == null)return;

        if(list.size() <= level)list.add(root.val);
        else list.set(level, root.val);

        preorder(root.left, level+1);
        preorder(root.right, level+1);
    }
}