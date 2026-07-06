class Solution {
    static boolean isvalidanswer(int[] nums , int k , int LargestSum) {
        int sumcount = 1;
        int largest = 0;

        for(int i = 0; i < nums.length;i++) {
            if(largest + nums[i] <= LargestSum) {

                largest = largest + nums[i];
            }
            else {
                sumcount++;
                if(sumcount > k || nums[i] > LargestSum ) {
                    return false; 
                }
                else {
                    largest = 0;
                    largest  = largest + nums[i];
                }
            }
        }

        return true;

    }
    public int splitArray(int[] nums, int k) {
    


        int n = nums.length;
        int s = 1;

        int sum = 0;
        for(int i = 0;i<n;i++) {
            sum += nums[i];
        }

        int e = sum;

        int ans = e;

        while(s <= e) {
            int mid = s + (e -s)/2;

            if(isvalidanswer( nums, k , mid)){
                ans = mid;

                e =  mid  - 1;
            } else {
                 
                 s = mid + 1;
            }
        }

        return ans;
        
    }
}