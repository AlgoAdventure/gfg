class Solution {
    public ArrayList<Integer> palQueries(String s, int[][] queries) {
        // code here
         final int BASE = 31;
    final int MOD1 = 1000000007;
    final int MOD2 = 1000000009;
        int n = s.length();
        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];
        long[] prefixHash1 = new long[n + 1];
        long[] prefixHash2 = new long[n + 1];
        long[] revHash1 = new long[n + 1];
        long[] revHash2 = new long[n + 1];

        pow1[0] = pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow1[i] = (pow1[i - 1] * BASE) % MOD1;
            pow2[i] = (pow2[i - 1] * BASE) % MOD2;
        }

        // Prefix hash
        for (int i = 0; i < n; i++) {
            prefixHash1[i + 1] = (prefixHash1[i] * BASE + s.charAt(i)) % MOD1;
            prefixHash2[i + 1] = (prefixHash2[i] * BASE + s.charAt(i)) % MOD2;
        }

        // Reverse prefix hash
        for (int i = n - 1; i >= 0; i--) {
            revHash1[n - i] = (revHash1[n - i - 1] * BASE + s.charAt(i)) % MOD1;
            revHash2[n - i] = (revHash2[n - i - 1] * BASE + s.charAt(i)) % MOD2;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int len = r - l + 1;

            // Forward hash
            long hash1 = (prefixHash1[r + 1] - (prefixHash1[l] * pow1[len]) % MOD1 + MOD1) % MOD1;
            long hash2 = (prefixHash2[r + 1] - (prefixHash2[l] * pow2[len]) % MOD2 + MOD2) % MOD2;

            // Reverse hash
            int revL = n - r - 1;
            int revR = n - l - 1;

            long revH1 = (revHash1[revR + 1] - (revHash1[revL] * pow1[len]) % MOD1 + MOD1) % MOD1;
            long revH2 = (revHash2[revR + 1] - (revHash2[revL] * pow2[len]) % MOD2 + MOD2) % MOD2;

            if (hash1 == revH1 && hash2 == revH2) {
                res.add(1);
            } else {
                res.add(0);
            }
        }
        return res;
    }
}