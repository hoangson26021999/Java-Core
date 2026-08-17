package experiments.accessmodifier;

import java.io.*;
import java.lang.reflect.*;
import java.security.*;

/**
 * HackerRank — Java Inner Class / Private Members challenge.
 *
 * Demonstrates:
 *   - Accessing a PRIVATE inner class from outside using reflection.
 *   - The Inner.Private class is private, so it cannot be instantiated directly.
 *     The solution uses 'new Inner().new Private()' from within the same outer class.
 *   - A SecurityManager trick (deprecated since Java 17) to trap System.exit() calls.
 *   - Bitwise power-of-2 check: (num & (num-1)) == 0
 *
 * This file is in experiments/ because it is a HackerRank submission, not a
 * standalone Java learning example. SecurityManager is deprecated in Java 17+.
 */
public class PrivateInnerClassSolution {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());

            // Must be declared as Object to hold a reference to the private inner class
            Object o = new Inner().new Private();

            System.out.println(num + " is " + ((PrivateInnerClassSolution.Inner.Private) o).powerof2(num));
            System.out.println("An instance of class: "
                    + o.getClass().getCanonicalName() + " has been created");

        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

    static class Inner {
        private class Private {
            /** Returns whether num is a power of 2 using the bitwise trick: n & (n-1) == 0 */
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }
}

/** Prevents System.exit() calls from terminating the JVM during HackerRank testing. */
class DoNotTerminate {

    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersionUID = 1L;
    }

    @SuppressWarnings("removal") // SecurityManager is deprecated since Java 17
    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
