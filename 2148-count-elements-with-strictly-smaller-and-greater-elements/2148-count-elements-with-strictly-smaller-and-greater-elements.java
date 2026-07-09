class Solution {
    public int countElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for(int num : nums) {
            min = Math.min(min , num);
            max = Math.max(max , num );

        }

        int count = 0;

        for(int num : nums) {
            if(min < num && max > num ) {
                count ++;
            }
        }
        return count;
    }
}