class Solution {
    public int countPairs(String[] arr) {
        // code here
         Map<String, Integer> maskCount = new HashMap<>();
        int totalPairs = 0;

        for (String word : arr) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                chars[i] = '*';
                String masked = new String(chars);
                totalPairs += maskCount.getOrDefault(masked, 0);
                maskCount.put(masked, maskCount.getOrDefault(masked, 0) + 1);
                chars[i] = original; // restore
            }
        }

        return totalPairs;
    }
}