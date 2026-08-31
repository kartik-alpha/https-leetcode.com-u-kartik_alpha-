class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer ,Integer> map = new HashMap<>();

        map.put(0,1);  // start array 0  ki value 1;

        int count = 0; // count the output------

        int sum = 0;

         for(int num : nums) {
            sum += num;

            if(map.containsKey(sum - k)){   // check the vlaue 

            //add the value 
            count += map.get(sum - k); 

            }

            map.put(sum , map.getOrDefault(sum , 0) + 1);
         }    


         return count;
        
    }
}