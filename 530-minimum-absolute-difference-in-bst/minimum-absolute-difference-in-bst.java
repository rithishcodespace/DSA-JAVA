class Solution {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
       inorder(root);
       int min = Integer.MAX_VALUE, prev = list.get(0);
       for(int i=1;i<list.size();i++){
        min = Math.min(min,list.get(i)-prev);
        prev = list.get(i);
       } 
       return min;
    }
    public void inorder(TreeNode root){
        if(root == null)return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}