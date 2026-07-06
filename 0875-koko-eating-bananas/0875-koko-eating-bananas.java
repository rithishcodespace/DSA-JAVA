// binary search

// h -> no.of hours available
// k -> bananas per hour
// if the pile has lesser bananas than k, it won't eat other pile bananas, so ceil division

// tc: O(logn)

// tc: O(nlogm)
// sc: O(1)

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=1000000000, ans=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(hour(mid, piles) <= h){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
    public long hour(int k, int[] piles){
        long hours = 0;
        for(int i=0;i<piles.length;i++){
            hours += (piles[i]+(k-1))/k;
        }
        return hours;
    }
}

// If k = 4:
// Pile 3 → needs 1 hour (ceil(3/4))
// Pile 6 → needs 2 hours (ceil(6/4))
// Pile 7 → needs 2 hours (ceil(7/4))
// Pile 11 → needs 3 hours (ceil(11/4))
// Total = 8 hours 