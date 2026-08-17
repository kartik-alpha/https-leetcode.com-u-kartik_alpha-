class Solution {
    static void solve(String digits , List<String> ans , int index , StringBuilder output , String[] maping) {

        if(index >= digits.length()) {
            ans.add(output.toString());
            return;
        }


        int value = digits.charAt(index) - '0';
        String mapper  = maping[value];

        for(int i = 0; i < mapper.length();i++) {
            output.append(mapper.charAt(i));

            solve(digits , ans , index + 1 , output , maping);

            output.deleteCharAt(output.length() - 1);
        }
    }
    
      public List<String> letterCombinations(String digits) {
            String[] maping = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

     List<String>  ans = new ArrayList<>();

     int index = 0;

     StringBuilder output = new StringBuilder();

     solve(digits , ans , index , output , maping);

     return ans;


    /*

    List<String>  ans = new ArrayList<>();
    String[] map = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    void solve(String digits , int index , StringBuilder output) {

        if(index == digits.length()){
            ans.add(output.toString());
            return;
        }
          int digit = digits.charAt(index) - '0';
        String letter = map[digit];

        for(int i = 0; i < letter.length();i++) {
            output.append(letter.charAt(i));

            solve(digits  , index + 1 , output);

            output.deleteCharAt(output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
        return ans;

        solve(digits , 0 , new StringBuilder());
        return ans;
*/

    }
}

