class Solution {
    static void solve(int[] candidates , int target , int index ,  List<Integer> output , List<List<Integer>> ans ) {

        //base case 
        if(target == 0)  {
        ans.add(new ArrayList<>(output));
        return;
        }

        if(target < 0 ) return;
        if(index >= candidates.length) return;



        output.add(candidates[index]);
        
            solve(candidates , target - candidates[index] , index + 1 , output , ans);

            output.remove(output.size() - 1);

            while( index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
                index++;
            }

            solve(candidates , target , index + 1 , output , ans);


    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int index = 0;

        solve(candidates , target , index , output ,ans);

        return ans;
        
    }
}