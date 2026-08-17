package functional;

import java.util.function.Consumer;

/**
 * Demonstrates variable scoping rules inside lambda expressions.
 *
 * Key concepts:
 *   - A lambda can access variables from the enclosing scope, but those variables
 *     must be EFFECTIVELY FINAL — they cannot be reassigned after the lambda captures them.
 *   - 'this' inside a lambda refers to the ENCLOSING CLASS instance, not the lambda itself.
 *     (Contrast with anonymous classes where 'this' refers to the anonymous class.)
 *   - When a field name is shadowed at multiple levels (outer class, inner class, method parameter),
 *     the lambda captures the innermost scope by default.
 *   - Use EnclosingClass.this.field to explicitly reach an outer level.
 *
 * Expected output (calling methodInFirstLevel(23)):
 *   x = 23                        ← method parameter x (innermost scope)
 *   y = 23                        ← lambda parameter y (= method parameter x passed in)
 *   z = 2                         ← effectively-final local variable z
 *   this.x = 1                    ← FirstLevel's own field x
 *   LambdaScopeExample.this.x = 0 ← outer class field x
 */
public class LambdaScopeExample {

    public int x = 0; // outer class field

    class FirstLevel {

        public int x = 1; // inner class field — shadows outer x

        void methodInFirstLevel(int x) {
            // x here is the method parameter (= 23 when called from main)
            // It shadows both the inner class field and the outer class field.

            int z = 2; // effectively final — not reassigned, so lambda can capture it
            // z = 3; // uncommenting this would cause a compile error in the lambda below

            Consumer<Integer> myConsumer = (y) -> {
                // Inside the lambda:
                // - 'x' refers to the method parameter (innermost scope = 23)
                // - 'this' refers to FirstLevel (the enclosing instance), NOT the lambda
                // - 'LambdaScopeExample.this' reaches the outer class instance
                System.out.println("x = " + x);                               // method param
                System.out.println("y = " + y);                               // lambda param
                System.out.println("z = " + z);                               // captured local
                System.out.println("this.x = " + this.x);                     // FirstLevel.x
                System.out.println("LambdaScopeExample.this.x = " + LambdaScopeExample.this.x); // outer x
            };

            myConsumer.accept(x); // passes method parameter x as y
        }
    }

    public static void main(String[] args) {
        LambdaScopeExample outer = new LambdaScopeExample();
        LambdaScopeExample.FirstLevel inner = outer.new FirstLevel();
        inner.methodInFirstLevel(23);
    }
}
