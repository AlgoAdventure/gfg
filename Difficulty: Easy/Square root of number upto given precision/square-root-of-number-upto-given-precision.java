class Solution {
    public double squareRoot(int n, int p) {
        // code here
        int start = 0, end = n;
        double root = 0.0;

        // Step 1: Binary search for integer part
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid * mid == n) {
                root = mid;
                break;
            }
            if (mid * mid < n) {
                root = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Step 2: Add decimal precision
        double increment = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += increment;
            }
            root -= increment; // overshot, go back
            increment /= 10;
        }

        // Round to 'p' decimal places
        return Math.round(root * Math.pow(10, p)) / Math.pow(10, p);
    }
}