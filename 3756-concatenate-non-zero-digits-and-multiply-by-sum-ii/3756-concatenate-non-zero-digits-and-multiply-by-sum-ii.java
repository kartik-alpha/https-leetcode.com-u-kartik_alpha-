import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> dig = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos.add(i);
                dig.add(d);
            }
        }

        int m = dig.size();
        long[] pre = new long[m + 1];
        long[] sum = new long[m + 1];
        long[] pow = new long[m + 1];
        pow[0] = 1;

        for (int i = 1; i <= m; i++) {
            pow[i] = pow[i - 1] * 10 % MOD;
            pre[i] = (pre[i - 1] * 10 + dig.get(i - 1)) % MOD;
            sum[i] = sum[i - 1] + dig.get(i - 1);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = lower(pos, queries[i][0]);
            int r = upper(pos, queries[i][1]) - 1;

            if (l > r) continue;

            int len = r - l + 1;
            long x = (pre[r + 1] - pre[l] * pow[len] % MOD + MOD) % MOD;
            long sm = sum[r + 1] - sum[l];

            ans[i] = (int) (x * (sm % MOD) % MOD);
        }

        return ans;
    }

    private int lower(ArrayList<Integer> a, int x) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (a.get(m) >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upper(ArrayList<Integer> a, int x) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (a.get(m) > x) r = m;
            else l = m + 1;
        }
        return l;
    }
}