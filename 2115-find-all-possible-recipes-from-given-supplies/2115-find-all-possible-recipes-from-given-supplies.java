// topo sort - kahn
// indegree[recipy] = how much ingredients still i need

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> graph = new HashMap<>();
        List<String> res = new ArrayList<>();
        HashSet<String> recps = new HashSet<>();
        HashMap<String, Integer> indegree = new HashMap<>();        

        for(String r : recipes)recps.add(r);
        for(int i=0;i<recipes.length;i++){
            if(!indegree.containsKey(recipes[i]))indegree.put(recipes[i], 0);
            indegree.put(recipes[i], ingredients.get(i).size());

            for(int j=0;j<ingredients.get(i).size();j++){
                String ingredient = ingredients.get(i).get(j);
                if(!graph.containsKey(ingredient))graph.put(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipes[i]);
            }
        }

        Queue<String> q = new LinkedList<>();
        for(String s : supplies)q.add(s);

        while(!q.isEmpty()){
            String u = q.poll();
            if(recps.contains(u)){
                res.add(u);
            }

            for(String v : graph.getOrDefault(u, new ArrayList<>())){
                indegree.put(v, indegree.get(v)-1);
                if(indegree.get(v) == 0){
                    q.add(v);
                }
            }
        }

        return res;
    }
}