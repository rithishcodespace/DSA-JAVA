// intuition - [3,1,5,4,2]
// ans = 3 (intially - must be inside ans, since i need to increment atleast target[0] times) [+3]
// 3 -> 1 (to reach 1, i dont want to increment any segments) [+0]
// 1 -> 5 (to reach 5, i need to increment 4, since 1's segement stopped incrmenting right there) [+4]

// before submission is the brute force

class Solution {
    public int minNumberOperations(int[] target) {
        int ans = target[0];

        for(int i=1;i<target.length;i++){
            if(target[i-1] < target[i])ans += target[i] - target[i-1];
        }

        return ans;
    }
}