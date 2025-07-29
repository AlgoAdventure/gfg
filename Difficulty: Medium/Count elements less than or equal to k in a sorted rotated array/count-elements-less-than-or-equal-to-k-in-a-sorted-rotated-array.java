class Solution {
    public int countEleLessThanOrEqual(List<Integer> arr, int k) {
        int n = arr.size();
        int pivot = findPivot(arr);
        
        int count = 0;
        count += countLE(arr, 0, pivot - 1, k);     // Left sorted part
        count += countLE(arr, pivot, n - 1, k);     // Right sorted part
        
        return count;
    }

    // Count elements ≤ k in sorted segment using binary search
    private int countLE(List<Integer> arr, int low, int high, int k) {
        int ans = -1;
        int start = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans == -1 ? 0 : (ans - start + 1);
    }

    // Find the index of the minimum element (pivot) in rotated sorted array
    private int findPivot(List<Integer> arr) {
        int n = arr.size();
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) > arr.get(high)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;  // Index of the minimum element
    }
}
