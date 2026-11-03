class Solution {
    public int findMaxLength(int[] nums) {
        HashMap <Integer , Integer > map = new HashMap<>();
        map.put( 0 , -1);

        int maxLen = 0;
        int balance = 0;

        for(int i = 0; i < nums.length;i++) {

            balance += (nums[i] == 1) ? 1 : -1;
        

        if(map.containsKey(balance)) {

            maxLen = Math.max(maxLen , i - map.get(balance));
        }
        else {
            map.put(balance , i);

        }
        }
        return maxLen;
    }
}