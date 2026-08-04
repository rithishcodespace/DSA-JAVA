class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        int[] map = new int[max+1];

        for(int num : nums){
            map[num] = 1;
        }

        for(int i=min;i<=max;i++){
            if(map[i] == 0)list.add(i);
        }

        return list;
    }
}