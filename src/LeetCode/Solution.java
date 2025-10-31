package LeetCode;

/**
 * Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a = 0 ;
        int b = a + 1 ;
        int count = 0 ;
        int cur = 1 ;
        while (b != s.length()){
            boolean c =false ;
            for (int i = a  ; i < b ; i++ ) {
                if (s.charAt(b) == s.charAt(i)) c = true;
            }
            if(!c) {
                cur ++;
                b ++;
            } else {
                if (cur >= count )  count = cur ;
                a = b ;
                b = b + 1 ;
                cur = 1 ;
            }
        }
        return count ;



    }
}
