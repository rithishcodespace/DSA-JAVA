// traverse original graph, don't push new nodes in the queue

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return null;

        HashMap<Node,Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>())); // origina -> copy

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            for(Node neigh : curr.neighbors){
               // if not cloned, clone it - acts as visited node
               if(!map.containsKey(neigh)){
                 map.put(neigh, new Node(neigh.val, new ArrayList<>()));
                 queue.add(neigh);
               }

               // connect neigh of original to clone
               map.get(curr).neighbors.add(map.get(neigh));
            }

        }

        return map.get(node);
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/