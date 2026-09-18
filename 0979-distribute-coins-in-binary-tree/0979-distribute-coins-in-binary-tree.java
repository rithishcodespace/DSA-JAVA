// I listen to the coin request from my children, and pass the coins to fullfill their requirements
// If i had any extra coins after fullfillilng my children, i will pass those to my father

class Solution {
    public int distributeCoins(TreeNode root) {
        TreeNode parent = new TreeNode();
        return post_order(root, parent);
    }
    public int post_order(TreeNode curr, TreeNode parent){ // no.of moves needed within this subtree
        if(curr == null)return 0;

        int moves = post_order(curr.left, curr) + post_order(curr.right, curr);

        int from_this = curr.val-1; // extra coins (+), defecient(-)

        parent.val += from_this; // consume or add coins to your parent

        moves += Math.abs(from_this); // coins moved

        return moves;   
    }
}