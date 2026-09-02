class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1, maxArea=0;

        while(l<r){
            int length = Math.min(height[l], height[r]);
            int breadth = r-l;

            int area = length*breadth;

            maxArea = Math.max(maxArea, area);

            if(height[l] > height[r]){
                r--;
            }
            else l++;
        }

        return maxArea;
    }
}