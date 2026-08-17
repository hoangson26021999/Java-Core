package experiments.interfaces;

/**
 * Incomplete experiment — exploring structural typing vs. nominal typing.
 *
 * Question being explored:
 *   If a class has the same method signatures as an interface but does NOT
 *   formally implement it, can it be used where the interface is expected?
 *
 * Answer: No. Java uses NOMINAL typing — the class must explicitly declare
 *   'implements DoItInterface'. Having matching method signatures is not enough.
 *   Contrast with languages like TypeScript (structural typing) where it would work.
 *
 * This file is in experiments/ because the interesting code is commented out
 * and the experiment was never completed.
 */
public class DogExperiment {

    public void shout() {
        System.out.println("bbbb");
    }

    public int id() {
        return 0;
    }

    public static void main(String[] args) {
        DogExperiment dog = new DogExperiment();
        dog.shout();

        // This would NOT compile even if DogExperiment had all of DoItInterface's methods:
        // DoItInterface d = dog; // compile error — DogExperiment does not implement DoItInterface

        // dog.type() also won't compile for the same reason — type() is a DoItInterface default method
        // dog.type(); // compile error
    }
}
