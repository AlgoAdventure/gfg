class Solution {
    public int substrWithVowels(String s1, String s2) {
        // code here
         Set<Character> required = new HashSet<>();
        for (char c : s1.toCharArray()) {
            required.add(c);
        }

        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0, minLen = Integer.MAX_VALUE;
        int matchCount = 0;

        for (int right = 0; right < s2.length(); right++) {
            char ch = s2.charAt(right);
            if (required.contains(ch)) {
                windowCount.put(ch, windowCount.getOrDefault(ch, 0) + 1);
                if (windowCount.get(ch) == 1) {
                    matchCount++;
                }
            }

            while (matchCount == required.size()) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = s2.charAt(left);
                if (required.contains(leftChar)) {
                    windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                    if (windowCount.get(leftChar) == 0) {
                        matchCount--;
                    }
                }
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}