class Solution {
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        List<StringBuilder> list = new ArrayList<>();
        inorder(root,list,sb);
        for(int i=0;i<list.size();i++){
            sum += binaryToDecimal(list.get(i));
        }
        return sum;
    }
    public void inorder(TreeNode root, List<StringBuilder> list, StringBuilder sb){
        if(root == null)return;

        sb.append(String.valueOf(root.val)); // append to sb

        inorder(root.left, list, sb);

        if(root.left == null && root.right == null){ // leaf node
            list.add(new StringBuilder(sb));
        }

        inorder(root.right, list, sb);

        sb.deleteCharAt(sb.length()-1); // backtrack
    }
    public int binaryToDecimal(StringBuilder sb){
        int sum = 0, power = 0;

        for(int i=sb.length()-1;i>=0;i--){
            sum += (sb.charAt(i) - '0') * (int)Math.pow(2, power++);
        }
        return sum;
    }
}