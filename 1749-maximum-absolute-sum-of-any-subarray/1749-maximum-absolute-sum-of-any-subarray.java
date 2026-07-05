class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxend = 0;  
        int minend = 0;

        int maxsum = 0;
        int minsum = 0;

        for(int num : nums) {
            // max subarray
            maxend = Math.max(num , num + maxend);
            maxsum = Math.max(maxend , maxsum);

            //min subarray

            minend = Math.min(num , num + minend);
            minsum = Math.min(minend , minsum);
        }

        return  Math.max(maxsum , Math.abs(minsum));
    }
}