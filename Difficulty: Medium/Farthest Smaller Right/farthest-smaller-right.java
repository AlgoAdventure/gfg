class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        // Code Here
         int n = arr.length;
         int[] result = new int[n];
        int[] minSuffix = new int[n];

        // Build the suffix minimum array from right to left
        minSuffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(arr[i], minSuffix[i + 1]);
        }

        // For each element, find the farthest smaller element to its right
        for (int i = 0; i < n; i++) {
            int low = i + 1;
            int high = n - 1;
            int ans = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (minSuffix[mid] < arr[i]) {
                    ans = mid;  // update farthest found so far
                    low = mid + 1; // try to find farther on right
                } else {
                    high = mid - 1;
                }
            }

            result[i] = ans;
        }

         ArrayList<Integer> resList = new ArrayList<>();
        for (int val : result) {
            resList.add(val);
        }

        return resList;
    }
}