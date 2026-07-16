// level order traversal

// SERIALIZE
// don't skip null children.
// if node itself is null -> store '#'

// DESERIALIZE
// read nodes level by level.
// for each parent, assign the next two values as its left and right child.

// Serialize:
// Time: O(n)
// Space: O(n)

// Deserialize:
// Time: O(n)
// Space: O(n)

public class Codec {

    // engineer
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        if(root == null)return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node == null) {
                sb.append("#,");
                continue;
            }

            sb.append(node.val).append(",");

            queue.add(node.left);
            queue.add(node.right);
        }

        sb.deleteCharAt(sb.length() - 1); //removes last ','
        return sb.toString();
    }

    // reverse engineer
    public TreeNode deserialize(String str) {
        if (str.isEmpty())return null;

        String[] data = str.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(data[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int idx = 1;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            // left child
            if(idx < data.length && !data[idx].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(data[idx]));
                queue.add(node.left);
            }
            idx++;

            // right child
            if(idx < data.length && !data[idx].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(data[idx]));
                queue.add(node.right);
            }
            idx++;
        }

        return root;
    }
}