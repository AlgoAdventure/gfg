class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // code here
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Preprocess: store indices of each number
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], x = q[2];
            if (!map.containsKey(x)) {
                result.add(0);
                continue;
            }

            ArrayList<Integer> indices = map.get(x);
            int left = lowerBound(indices, l);
            int right = upperBound(indices, r);
            result.add(right - left);
        }

        return result;
    }

    // First index >= target
    private int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    // First index > target
    private int upperBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) > target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}