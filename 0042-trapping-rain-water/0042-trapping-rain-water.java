// for each bar, find the min(left highest, right highest) bar (level at which water will stag upon current bar)
// found level - height(current bar) => water stagged on current bar
// like this we sum up stagged water height on each bar

// tc: O(n)
// sc: O(n)

class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];

        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int i=height.length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        // sum water stagged upon each block
        int totalWater = 0;
        for(int i=0;i<height.length;i++){
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }
}