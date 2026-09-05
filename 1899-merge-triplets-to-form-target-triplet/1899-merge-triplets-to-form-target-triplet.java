class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean one=false, two=false, three=false;

        for(int[] trip : triplets){
            int a = trip[0], b = trip[1], c = trip[2];
            
            // eliminate the triplet, that is greater than desired
            if(a > target[0] || b > target[1] || c > target[2]){
                continue;
            }

            if(a == target[0])one=true;
            if(b == target[1])two=true;
            if(c == target[2])three=true;

        } 

        return one && two && three;
    }
}