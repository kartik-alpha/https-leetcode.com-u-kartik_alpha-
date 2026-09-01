class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap <Integer ,  Integer> map = new HashMap<>();

        int preSum = 0;

        for(int i = 0; i < nums.length;i++) {

            preSum += nums[i];

            int rem = preSum%k;

            if(rem == 0 && i >= 1) return true;

            if(map.containsKey(rem)) {

                int index = map.get(rem);

                if( (i  - index) >= 2 ) return true;
            }

            else 
            map.put(rem ,i);
        }

        return false;
        
    }
}