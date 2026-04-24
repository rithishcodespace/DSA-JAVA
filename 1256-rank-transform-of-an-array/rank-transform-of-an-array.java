class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int rank = 1;
        int[] copy = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            copy[i] = arr[i];
        }
        Arrays.sort(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))continue;
            map.put(arr[i],rank++);
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(copy[i]);
        }

        return arr;
    }
}