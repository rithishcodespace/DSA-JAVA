class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(i==0)temp.add(nums[i]);
            else{
                if(nums[i]-nums[i-1] != 1){
                    String str = "";
                    if(temp.size() == 1){
                        str += temp.get(0);
                    }
                    else{
                        str += temp.get(0);
                        str += "->";
                        str += temp.get(temp.size()-1);
                    }
                    ans.add(str);
                    temp.clear();
                }
                temp.add(nums[i]);
            }
        }

        if(temp.size() > 0){
            String str = "";
            if(temp.get(0) == temp.get(temp.size()-1)){
                str += temp.get(0);
            }
            else{
                str += temp.get(0);
                str += "->";
                str += temp.get(temp.size()-1);
            }
            ans.add(str);
        }

        return ans;
    }
}