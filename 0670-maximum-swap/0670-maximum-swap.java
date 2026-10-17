class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);

        int[] maxNums = new int[sb.length()];
        int[] maxIdxs = new int[sb.length()];

        int max = sb.charAt(sb.length()-1)-'0', maxIdx = sb.length()-1;

        for(int i=sb.length()-1;i>=0;i--){
            int x = sb.charAt(i)-'0';

            if(x > max){
                max = x;
                maxIdx = i;
            }

            maxNums[i] = max;
            maxIdxs[i] = maxIdx;
        }

        int idx=0;
        while(idx < sb.length() && (sb.charAt(idx)-'0') == maxNums[idx]) {
            idx++;
        }

        if(idx < sb.length()){
            char temp = sb.charAt(idx);
            sb.setCharAt(idx, sb.charAt(maxIdxs[idx]));
            sb.setCharAt(maxIdxs[idx], temp);
        }

        return Integer.parseInt(sb.toString());
    }
}