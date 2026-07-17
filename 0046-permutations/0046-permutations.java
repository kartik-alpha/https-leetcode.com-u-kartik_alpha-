class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  ans = new ArrayList<>();
        solve(nums , 0 , ans);
        return ans;

    }

    private void solve(int[] nums , int index ,  List<List<Integer>>  ans ) {

        //base case 
        if(index == nums.length)  {
            List<Integer> temp = new ArrayList<>();
            for(int num : nums ) {
                temp.add(num);
            } 

            ans.add(temp);
            return;
        }

        for(int i = index ; i < nums.length;i++) {

            swap(nums , index , i);
            solve(nums , index + 1 , ans);
            swap(nums , index , i);
        }

    }

    private void swap(int[] nums , int i , int j ) {
        int temp = nums[i];
        nums[i]   = nums[j];
        nums[j]  = temp;
    
 }
}