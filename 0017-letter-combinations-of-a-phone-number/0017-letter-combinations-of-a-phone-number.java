class Solution {
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

    }
}