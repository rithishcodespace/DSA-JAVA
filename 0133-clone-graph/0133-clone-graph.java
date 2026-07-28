class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return null;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        map.put(node, new Node(node.val, new ArrayList<>()));
        queue.add(node);

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            for(Node neigh : curr.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh, new Node(neigh.val, new ArrayList<>()));
                    queue.add(neigh);
                }

                map.get(curr).neighbors.add(map.get(neigh));
            }
        }

        return map.get(node);
    }
}