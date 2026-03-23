// instead of min-heap, use max heap to maximize the probability

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // create adj_list
        List<List<Edge>> adj_list = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj_list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            adj_list.get(u).add(new Edge(v,p));
            adj_list.get(v).add(new Edge(u,p));
        }
        // dikstra
        double[] probabilities = new double[n];
        Arrays.fill(probabilities,0.0);
        probabilities[start_node] = 1.0;

        PriorityQueue<Edge> maxHeap = new PriorityQueue<>((a,b) -> {
            return Double.compare(b.probability, a.probability);
        });

        maxHeap.add(new Edge(start_node,1.0));

        while(!maxHeap.isEmpty()){
            Edge edge = maxHeap.poll();
            double probability = edge.probability;

            if(probabilities[edge.node] > probability){
                continue;
            }

            for(int i=0;i<adj_list.get(edge.node).size();i++){
                Edge newEdge = adj_list.get(edge.node).get(i);
                double newProbability = probability * newEdge.probability;

                if(newProbability > probabilities[newEdge.node]){
                    probabilities[newEdge.node] = newProbability;

                    maxHeap.add(new Edge(newEdge.node,newProbability));
                }
            }
        }

        return probabilities[end_node];
    }
}

class Edge{
    int node;
    double probability;

    Edge(int node, double probability){
        this.node = node;
        this.probability = probability;
    }
}