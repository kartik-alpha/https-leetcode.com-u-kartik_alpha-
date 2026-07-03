class Solution {
    public int maxSubArray(int[] nums) {
       int sum = 0;
       int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length;i++) {
            //Step 1 :- sum create krege
            sum = sum + nums[i];
            //step 2 :- maxi value update
            maxi = Math.max(maxi , sum );
            //step 3 :- sum check kre gee  -ve hai yaa nhi
            if(sum < 0) 
              sum = 0;
        }
        return maxi;
    }
}