// positions + binary search

class Solution {
    public int numMatchingSubseq(String s1, String[] words) {
        int count=0;
        // store the indexes of each element
        HashMap<Character,List<Integer>> hmap = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(!hmap.containsKey(s1.charAt(i))){
                hmap.put(s1.charAt(i), new ArrayList<>());
            }
            hmap.get(s1.charAt(i)).add(i);
        }

        // check for subsequences
        for(String s2 : words){
            if(isSubSequence(s2, hmap))count++;
        }

        return count;
    }
    public boolean isSubSequence(String str, HashMap<Character,List<Integer>> hmap){
        int prevIdx = -1;

        for(int i=0;i<str.length();i++){
            List<Integer> list = hmap.get(str.charAt(i));
            if(list == null){
                return false;
            }
            int pos = upperBound(prevIdx, list);
            if(pos == list.size())return false;
            prevIdx = list.get(pos);
        }

        return true;
    }
    public int upperBound(int target, List<Integer> list){
        int l=0, r=list.size()-1, ans=list.size();

        while(l <= r){
            int mid = (l+r)/2;

            if(list.get(mid) > target){
                r=mid-1;
                ans = mid;
            }
            else{
                l=mid+1;
            }
        }

        return ans;
    }
}