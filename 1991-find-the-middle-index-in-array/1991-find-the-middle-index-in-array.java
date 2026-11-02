class Solution {
    public int findMiddleIndex(int[] nums) {

         int totalSum = 0;

        // Step 1: Calculate total sum
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int leftSum = 0;

        // Step 2: Find pivot index
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            // Step 3: Check condition
            if (leftSum == rightSum) {
                return i;
            }

            // Step 4: Update left sum
            leftSum += nums[i];
        }

        return -1;
    
        
    }
}