// Sorting is not allowed (modifies the array).
// HashSet uses O(n) extra space.

// cycle detection with tortoise and hare
// Instead of storing pointers like a linked list, let the value point to the next index.

// 0 → 1
// 1 → 3
// 3 → 2
// 2 → 4
// 4 → 2

// 0 → 1 → 3 → 2 → 4
//            ↑_____|

// linkedlist cycle 2
// find the position where both pointers collide
// find the starting point of the cycle
//  disntance between start node to cycle point and cycle point to collision point is same

// tc: O(n)
// sc: O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // find the collision point
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);

        // find the starting point
        slow = 0;
        do{
            slow = nums[slow];
            fast = nums[fast];
        }
        while(slow != fast);

        return slow;
    }
}










