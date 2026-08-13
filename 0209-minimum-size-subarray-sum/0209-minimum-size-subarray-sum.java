class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        if(target == 0)
         return 0;
        if(nums.length == 0  || nums == null) {
            return 0;
        }

        int left = 0;
        int sum = 0;
        int answer = nums.length + 1;

        for(int right = 0;right < nums.length;right++) {

            sum += nums[right];

            while(sum >= target) {

                answer = Math.min(answer , right - left + 1);

                sum = sum - nums[left];
                left++;
            }
        }

        if(answer == nums.length + 1)  return 0;


        return answer;
    }
}