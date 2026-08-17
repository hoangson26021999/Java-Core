package experiments.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #3 — Longest Substring Without Repeating Characters
 *
 * Two implementations are kept side by side for comparison:
 *   1. Manual attempt — has a subtle bug (see note below).
 *   2. Sliding window solution — correct and optimal O(n).
 *
 * This file is in experiments/ because it is an algorithm practice submission,
 * not a canonical Java language concept example.
 */
public class LongestSubstringSliding {

    /**
     * Attempt 1 — manual approach.
     *
     * BUG: When a duplicate is found, the window resets to a=a+1 and cur=1,
     * but s.charAt(a) is never added to the set after the reset.
     * Also, if the longest window ends at the last character, 'cur' is never
     * compared to 'count', so the final window may be missed.
     */
    public int lengthOfLongestSubstringManual(String s) {
        if (s.isEmpty()) return 0;
        int a = 0;
        int b = a + 1;
        int count = 0;
        int cur = 1;
        Set<Character> set = new HashSet<>();
        while (b != s.length()) {
            boolean duplicate = set.contains(s.charAt(b));
            if (!duplicate) {
                set.add(s.charAt(b));
                cur++;
                b++;
            } else {
                set.clear();
                if (cur >= count) count = cur;
                a = a + 1;
                b = a + 1;
                cur = 1;
                // BUG: s.charAt(a) is not re-added to set after reset
            }
        }
        return count; // BUG: misses the case where the longest window ends at the last char
    }

    /**
     * Solution — sliding window (optimal).
     *
     * Maintain a window [left, right]. Expand right until a duplicate is found,
     * then shrink from left until the duplicate is removed.
     * Track the maximum window size seen at each valid state.
     *
     * Time: O(n)  Space: O(min(n, alphabet_size))
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> window = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            // Shrink from left until the duplicate character is removed
            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringSliding sol = new LongestSubstringSliding();

        System.out.println("=== Sliding window (correct) ===");
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(sol.lengthOfLongestSubstring(""));         // 0

        System.out.println("\n=== Manual attempt (buggy) ===");
        System.out.println(sol.lengthOfLongestSubstringManual("abcabcbb")); // may differ
        System.out.println(sol.lengthOfLongestSubstringManual("pwwkew"));   // may differ
    }
}
