class Solution {
    PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> {
        if(a.equals(b))return 0;
        for(int i=0;i<Math.min(a.length(),b.length());i++){
            if(a.charAt(i) != b.charAt(i)){
                return a.charAt(i) - b.charAt(i);
            }
        }
        return a.length()-b.length();
    });
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        in_order(root,sb);
        return minHeap.poll();
    }
    public void in_order(TreeNode root, StringBuilder sb){
        if(root == null)return;

        char ch = (char)(97+root.val);
        sb.append(ch);

        if(root.left == null && root.right == null){
            String str = reverse(sb);
            minHeap.add(str);
        }

        in_order(root.left, sb);
        in_order(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }
    public String reverse(StringBuilder sb){
        String str = "";
        for(int i=sb.length()-1;i>=0;i--){
            str += sb.charAt(i);
        }
        return str;
    }
}