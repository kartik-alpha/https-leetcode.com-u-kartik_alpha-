class Solution {
    static void solve(int[] candidates, int target, int index ,List<Integer> output,  List<List<Integer>> ans ) {
        //base case
        if(target == 0) {
        ans.add(new ArrayList<>(output));
        return;
        }

        if(index >= candidates.length) return;
        if(target < 0) return;
        


    output.add(candidates[index]);

    solve(candidates , target - candidates[index] , index , output , ans);

    //backtracking 
    output.remove(output.size() - 1);

    solve(candidates , target , index + 1 , output ,ans);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int index = 0;

        solve(candidates , target ,index, output , ans);
        return ans;


        
    }
}