// even index -> increases the sum
// odd index -> decreases the sum

class Solution {
    public long maxAlternatingSum(int[] arr) {
        long sum=0;
        int evenIdx = (arr.length+1)/2;

        // find the larger elements by sorting
        Integer[] nums = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i] = new Integer(arr[i]);
        }
        Arrays.sort(nums, (a,b) -> Integer.compare(Math.abs(b), Math.abs(a)));

        // add evenIdx count
        for(int i=0;i<evenIdx;i++){
            sum += (long)nums[i]*nums[i];
        }

        // minus oddIdx count
        for(int i=evenIdx;i<nums.length;i++){
            sum -= (long)nums[i]*nums[i];
        }

        return sum;
    }
}