class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        /*
              Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int complement = -nums[i] - nums[j];

                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    res.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(res);
    }
}
*/
    
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        Collections.sort(temp); // ensures same triplets have same order
                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    
    }
}
