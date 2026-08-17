package experiments.tools;

/**
 * Scratch file used to verify that the SonarLint plugin is active in the IDE.
 *
 * This file is in experiments/tools/ because it has no learning content —
 * it was created solely to check that SonarLint highlights code quality issues.
 *
 * When SonarLint is working, it should flag:
 *   - 'Object a' is declared but its value is only used in System.out.println
 *     (not a real issue, but confirms the plugin is scanning).
 */
public class SonarLintTest {

    public static void main(String[] args) {
        System.out.println("Hello");
        Object a = new Object();
        System.out.println(a);
    }
}
