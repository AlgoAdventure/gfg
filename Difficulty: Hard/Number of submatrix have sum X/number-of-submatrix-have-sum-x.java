class Solution {
    public int countSquare(int[][] mat, int x) {
        // code here
         int n = mat.length;
        int m = mat[0].length;
        int[][] prefix = new int[n + 1][m + 1];

        // Step 1: Build 2D prefix sum matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int count = 0;

        // Step 2: Try all possible square sizes
        int maxLen = Math.min(n, m);
        for (int len = 1; len <= maxLen; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= m - len; j++) {
                    int r1 = i + 1, c1 = j + 1;
                    int r2 = i + len, c2 = j + len;

                    int sum = prefix[r2][c2] - prefix[r1 - 1][c2] - prefix[r2][c1 - 1] + prefix[r1 - 1][c1 - 1];
                    if (sum == x) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}