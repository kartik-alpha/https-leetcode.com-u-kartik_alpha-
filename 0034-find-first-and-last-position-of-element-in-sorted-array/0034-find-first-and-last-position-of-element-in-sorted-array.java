class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = firstPosition(nums , target);
        int last = lastPosition(nums , target);

        return new int[]{first , last};

    }


    private int firstPosition(int[] nums , int target) {
        int s = 0;
        int n = nums.length - 1;
        int e = n;

         int ans = -1;

        while(s <= e) {
            int mid = s + (e -s)/2;

           

            if(nums[mid] == target) {

                ans  = mid;

                e = mid - 1;
            }
           else  if(nums[mid] < target) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
            
        }

        return ans;
        
    }


    private int lastPosition(int[] nums , int target ) {
        int s = 0;
        int n = nums.length - 1;
        int e = n;

         int ans = -1;
          while(s <= e) {
            int mid = s + (e -s)/2;

           

            if(nums[mid] == target) {

                ans  = mid;

                s = mid + 1;
            }
           else  if(nums[mid] < target) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
          
        }
      
    

    return ans;

    }

}





    

