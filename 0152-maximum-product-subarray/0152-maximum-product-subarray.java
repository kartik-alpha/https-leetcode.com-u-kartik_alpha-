class Solution {
    public int maxProduct(int[] nums) {

        // using kadan's algorithm check every number..
        int maxnumber = nums[0];
        int minnumber = nums[0];
        int ans       = nums[0];

        for(int i = 1; i <nums.length;i++) {

            if(nums[i]<0) {
                int temp = maxnumber;
                maxnumber = minnumber;
                minnumber = temp;
            }

            maxnumber = Math.max(nums[i] , maxnumber * nums[i]);
            minnumber = Math.min(nums[i] , minnumber * nums[i]);

            ans = Math.max(ans , maxnumber);
        }

        return ans;
    }
}