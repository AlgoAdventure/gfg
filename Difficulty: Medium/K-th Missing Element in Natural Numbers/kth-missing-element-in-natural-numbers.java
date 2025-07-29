class Solution {
    public int findKthSmall(int[] arr, int k) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int count = 0;
        int num = 1;

        while (true) {
            if (!set.contains(num)) {
                count++;
                if (count == k) {
                    return num;
                }
            }
            num++;
        }
        
    }
}