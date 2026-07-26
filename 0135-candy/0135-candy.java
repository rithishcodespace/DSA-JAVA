// tc: O(2n)
// sc: O(n)

class Solution {
    public int candy(int[] ratings) {
      int candies = 0, prevR = 1;

      int[] left = new int[ratings.length];

      // if i dont have left element or i'm lesser than left - give 1  
      for(int i=0;i<ratings.length;i++){
        if(i == 0 || ratings[i-1] >= ratings[i])left[i] = 1;
        else left[i] = left[i-1]+1;
      }
      // if i dont have right element or i'm lesser than right - give 1   
      for(int i=ratings.length-1;i>=0;i--){
        if(i == ratings.length-1 || ratings[i+1] >= ratings[i]){
            candies += Math.max(left[i],1);
            prevR = 1;
        }
        else{
            candies += Math.max(left[i], prevR+1);
            prevR = prevR+1;
        }
      }

      return candies;
    }
}