class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        char[] ch = s.toCharArray();

        int[] pos = new int[n];
        int[] dig = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int d = ch[i] - '0';
            if (d != 0) {
                pos[cnt] = i;
                dig[cnt++] = d;
            }
        }

        long[] preVal = new long[cnt + 1];
        long[] preSum = new long[cnt + 1];
        long[] pow = new long[cnt + 1];
        pow[0] = 1;

        for (int i = 1; i <= cnt; i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
            preVal[i] = (preVal[i - 1] * 10 + dig[i - 1]) % MOD;
            preSum[i] = preSum[i - 1] + dig[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int L = lower(pos, cnt, l);
            int R = upper(pos, cnt, r) - 1;

            if (L > R) continue;

            int len = R - L + 1;

            long x = (preVal[R + 1]
                    - preVal[L] * pow[len] % MOD
                    + MOD) % MOD;

            long sum = preSum[R + 1] - preSum[L];

            ans[i] = (int) (x * (sum % MOD) % MOD);
        }

        return ans;
    }

    private int lower(int[] a, int n, int x) {
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upper(int[] a, int n, int x) {
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] > x) r = m;
            else l = m + 1;
        }
        return l;
    }
}