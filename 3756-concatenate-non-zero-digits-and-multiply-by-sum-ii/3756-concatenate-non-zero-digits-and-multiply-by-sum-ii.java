import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        ArrayList<Integer> poss = new ArrayList<>();
        ArrayList<Integer> digit = new ArrayList<>();

        // Store non-zero digits and their positions
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                poss.add(i);
                digit.add(d);
            }
        }

        int m = digit.size();

        long[] prefvalue = new long[m + 1];
        long[] prefsum = new long[m + 1];
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;

        // Precompute powers of 10
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix value and prefix digit sum
        for (int i = 1; i <= m; i++) {
            prefvalue[i] = (prefvalue[i - 1] * 10 + digit.get(i - 1)) % MOD;
            prefsum[i] = prefsum[i - 1] + digit.get(i - 1);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int L = lowerBound(poss, l);
            int R = upperBound(poss, r) - 1;

            if (L > R) {
                ans[i] = 0;
                continue;
            }

            int len = R - L + 1;

            long sum = prefsum[R + 1] - prefsum[L];

            long x = (prefvalue[R + 1]
                    - (prefvalue[L] * pow10[len]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }

    // First index >= target
    private int lowerBound(ArrayList<Integer> list, int target) {
        int s = 0;
        int e = list.size();

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (list.get(mid) >= target)
                e = mid;
            else
                s = mid + 1;
        }

        return s;
    }

    // First index > target
    private int upperBound(ArrayList<Integer> list, int target) {
        int s = 0;
        int e = list.size();

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (list.get(mid) > target)
                e = mid;
            else
                s = mid + 1;
        }

        return s;
    }
}