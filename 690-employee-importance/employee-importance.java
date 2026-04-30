class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> hmap = new HashMap<>();

        for(Employee e : employees){
            hmap.put(e.id,e);
        }

        return dfs(id, employees, hmap);
    }
    public int dfs(int id, List<Employee> employees, HashMap<Integer,Employee> hmap){
        int sum = hmap.get(id).importance;
        for(int sub : hmap.get(id).subordinates){
            sum += dfs(sub, employees, hmap);
        }
        return sum;
    }
}

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
