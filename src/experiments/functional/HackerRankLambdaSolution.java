package experiments.functional;

import java.io.*;
import java.util.*;

/**
 * HackerRank — Java Lambda Expressions challenge.
 *
 * Demonstrates returning lambdas from factory methods:
 *   - isOdd()       → checks if a number is odd
 *   - isPrime()     → checks primality using sqrt optimization
 *   - isPalindrome() → checks if the decimal representation is a palindrome
 *
 * Input format:
 *   Line 1: T (number of test cases)
 *   Each subsequent line: <operation> <number>
 *     operation 1 → ODD/EVEN
 *     operation 2 → PRIME/COMPOSITE
 *     operation 3 → PALINDROME/NOT PALINDROME
 *
 * This file is in experiments/ because it is a HackerRank submission.
 * The lambda patterns shown here are also demonstrated more clearly in
 * functional/LambdaEvolutionExample.java.
 */
public class HackerRankLambdaSolution {

    interface PerformOperation {
        boolean check(int a);
    }

    static class MyMath {
        public static boolean checker(PerformOperation p, int num) {
            return p.check(num);
        }

        public static PerformOperation isOdd() {
            return a -> a % 2 != 0;
        }

        public static PerformOperation isPrime() {
            return a -> {
                if (a < 2) return false;
                for (int i = 2; i <= Math.sqrt(a); i++) {
                    if (a % i == 0) return false;
                }
                return true;
            };
        }

        public static PerformOperation isPalindrome() {
            return a -> {
                String str = String.valueOf(a);
                return str.equals(new StringBuilder(str).reverse().toString());
            };
        }
    }

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        String ans = null;

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int ch  = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (ch == 1) {
                op  = MyMath.isOdd();
                ret = op.check(num);
                ans = ret ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op  = MyMath.isPrime();
                ret = MyMath.checker(op, num);
                ans = ret ? "PRIME" : "COMPOSITE";
            } else {
                op  = MyMath.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = ret ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}
