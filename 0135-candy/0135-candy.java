class Solution {
    public int candy(int[] ratings) {
        int candies = 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        // left neigh check
        for(int i=0;i<ratings.length;i++){
            if(i > 0 && ratings[i-1] < ratings[i]){
                left[i] = left[i-1]+1;
            }
            else left[i] = 1;
        }

        // right neigh check
        for(int i=ratings.length-1;i>=0;i--){
            if(i<ratings.length-1 && ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }
            else right[i] = 1;
        }

        // take max
        for(int i=0;i<ratings.length;i++){
            candies += Math.max(left[i], right[i]);
        }

        return candies;
    }
}