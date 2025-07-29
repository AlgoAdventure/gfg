class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        // code here
         int n = mat.length;
        int m = mat[0].length;

        int[][] pre = new int[n][m];

        // Step 1: Build prefix sum matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pre[i][j] = mat[i][j];
                if (i > 0) pre[i][j] += pre[i - 1][j];
                if (j > 0) pre[i][j] += pre[i][j - 1];
                if (i > 0 && j > 0) pre[i][j] -= pre[i - 1][j - 1];
            }
        }

        // Step 2: Answer each query in O(1)
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            int total = pre[r2][c2];
            if (r1 > 0) total -= pre[r1 - 1][c2];
            if (c1 > 0) total -= pre[r2][c1 - 1];
            if (r1 > 0 && c1 > 0) total += pre[r1 - 1][c1 - 1];

            result.add(total);
        }

        return result;
    }
}
