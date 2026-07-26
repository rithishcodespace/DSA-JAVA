// tc: O(3n)
// sc: O(2n)

class Solution {
    public int candy(int[] ratings) {
      int candies = 0;

      int[] left = new int[ratings.length];
      int[] right = new int[ratings.length];

      // if i dont have left element or i'm lesser than left - give 1  
      for(int i=0;i<ratings.length;i++){
        if(i == 0 || ratings[i-1] >= ratings[i])left[i] = 1;
        else left[i] = left[i-1]+1;
      }
      // if i dont have right element or i'm lesser than right - give 1   
      for(int i=ratings.length-1;i>=0;i--){
        if(i == ratings.length-1 || ratings[i+1] >= ratings[i])right[i] = 1;
        else right[i] = right[i+1]+1;
      }

      // pick max of left and right
      for(int i=0;i<ratings.length;i++){
        candies += Math.max(left[i], right[i]);
      }

      return candies;
    }
}