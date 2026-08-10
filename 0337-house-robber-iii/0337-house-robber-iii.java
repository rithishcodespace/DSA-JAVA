// You cannot rob a parent and either of its direct children on the same night.

class Solution {
    public int rob(TreeNode root) {
        HashMap<String, Integer> dp = new HashMap<>();
        return Math.max(preorder(root, false, dp), preorder(root, true, dp));
    }
    public int preorder(TreeNode root, boolean p, HashMap<String, Integer> dp){
        if(root == null)return 0;

        String key = root + "#" + (p ? 1 : 0);

        if(dp.containsKey(key))return dp.get(key);

        // parent not stolen
        if(!p){
            int steal = root.val + preorder(root.left, true, dp) + preorder(root.right, true, dp);
            int not_steal = preorder(root.left, false, dp) + preorder(root.right, false, dp);

            dp.put(key,Math.max(steal, not_steal));
            return dp.get(key);
        }

        int l_not_steal = 0, r_not_steal = 0;

        // parent stolen
        if(p){
            l_not_steal = preorder(root.left, false, dp);
            r_not_steal = preorder(root.right, false, dp);
        }

        dp.put(key, l_not_steal + r_not_steal);

        return dp.get(key);
    }
}