class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;

        for(int i=0;i<landStartTime.length;i++){
            for(int j=0;j<waterStartTime.length;j++){
                int landFinish = landStartTime[i]+landDuration[i];
                int waterStart = Math.max(landFinish,waterStartTime[j]);
                int finish1 = waterStart+waterDuration[j];
                min = Math.min(min,finish1);

                int waterFinish = waterStartTime[j]+waterDuration[j];
                int landStart = Math.max(waterFinish, landStartTime[i]);
                int finish2 = landStart+landDuration[i];
                min = Math.min(min,finish2);
            }
        }

        return min;
    }
}