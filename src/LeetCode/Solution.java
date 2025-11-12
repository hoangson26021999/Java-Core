package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 */
class Solution {
    /**
     * Tự nghĩ
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int a = 0;
        int b = a + 1;
        int count = 0;
        int cur = 1;
        Set<Character> set = new HashSet<>();
        while (b != s.length()) {
            boolean c = false;

            if (set.contains(s.charAt(b))) c = true;

            if (!c) {
                set.add(s.charAt(b));
                cur++;
                b++;
            } else {
                set.clear();
                if (cur >= count) count = cur;
                a = a + 1;
                b = a + 1;
                cur = 1;
            }
        }
        return count;
    }

        /**
         * Cách giải
         * @param s
         * @return
         */

        public int lengthOfLongestSubstring(String s, String solution) {
            if (s == null || s.isEmpty()) return 0;

            Set<Character> set = new HashSet<>();
            int left = 0, right = 0, maxLen = 0;

            while (right < s.length()) {
                char c = s.charAt(right);

                // Nếu bị trùng, thu nhỏ cửa sổ từ bên trái
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    left++;
                }

                set.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }

            return maxLen;
        }


}
