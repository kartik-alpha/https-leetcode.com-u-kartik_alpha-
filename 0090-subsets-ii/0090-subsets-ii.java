class Solution {

    static void solve(int[] nums , int index ,   List<Integer> output ,    List<List<Integer>> ans ) {

        //base case 
        if(index >= nums.length) {
          //  if(ans.contains(output)) return;
            ans.add(new ArrayList<>(output));

            return;
        }


        int currValue = nums[index];

        output.add(currValue);

        //exclude 
        solve(nums , index + 1,output,ans);

        //backtracking
        output.remove(output.size() - 1);

        while(index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        //include 
        solve(nums,index + 1,output,ans);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

         Arrays.sort(nums); 
        int index = 0;

        solve(nums , index , output , ans);
        
        return ans;
    }
}