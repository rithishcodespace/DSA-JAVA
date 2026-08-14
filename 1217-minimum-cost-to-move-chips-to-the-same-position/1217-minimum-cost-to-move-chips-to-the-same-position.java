// even indexes can move to other even indexes at free of cost
// odd indexes can move to other odd indexes at free of cost

// if i have more even, place all at even
// if i have more odd place all at odd

class Solution {
    public int minCostToMoveChips(int[] position) {
        int ans = 0;

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int p : position){
            if(p%2 == 0){
                even.add(p);
            }
            else odd.add(p);
        }

        if(even.size() >= odd.size()){ // move all odd indexes to one of the even
            ans = odd.size(); // to move from odd to even -> 1
        }
        else{ // move all even index to one of the odd one
            ans = even.size(); // to move from even to odd -> 1
        }

        return ans;
    }
}