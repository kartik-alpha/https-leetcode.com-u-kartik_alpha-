import java.util.*;

class Solution {

    static class Pair {
        int val, idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.val, b.val));

        // position of original node in sorted order
        int[] pos = new int[n];

        // connected component
        int[] comp = new int[n];

        int id = 0;
        pos[arr[0].idx] = 0;
        comp[0] = 0;

        for (int i = 1; i < n; i++) {

            pos[arr[i].idx] = i;

            if (arr[i].val - arr[i - 1].val > maxDiff)
                id++;

            comp[i] = id;
        }

        // farthest reachable in one edge
        int[] next = new int[n];

        int j = 0;

        for (int i = 0; i < n; i++) {

            while (j + 1 < n &&
                    arr[j + 1].val - arr[i].val <= maxDiff) {
                j++;
            }

            next[i] = j;
        }

        int LOG = 18;

        int[][] jump = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            jump[0][i] = next[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int u = pos[queries[q][0]];
            int v = pos[queries[q][1]];

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (u == v) {
                ans[q] = 0;
                continue;
            }

            if (comp[u] != comp[v]) {
                ans[q] = -1;
                continue;
            }

            int cur = u;
            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < v) {
                    cur = jump[k][cur];
                    steps += 1 << k;
                }
            }

            ans[q] = steps + 1;
        }

        return ans;
    }
}