class Solution {
    public long sumAndMultiply(int n) {

        String s = String.valueOf(n);
        StringBuilder ans = new StringBuilder();
        long sum = 0;

        for(char ch : s.toCharArray()) {
            if(ch != '0') {
                ans.append(ch);
                sum += ch - '0';
            }
    }

    long x;
    if(ans.length() == 0) {
        x = 0;
    } else {
        x = Long.parseLong(ans.toString());
    }

    return x * sum;



    
}
}