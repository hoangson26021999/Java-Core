package functional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Demonstrates the evolution from anonymous classes to lambda expressions to streams.
 *
 * This example follows the official Java tutorial progression, showing how each
 * approach to filtering and processing a collection became more concise over time.
 *
 * Progression:
 *   1. Named class implementing a functional interface (most verbose)
 *   2. printPersons() with a lambda as Predicate
 *   3. processPersons() with Predicate + Consumer lambdas
 *   4. processPersonsWithFunction() adding a Function to transform results
 *   5. processElements<X,Y>() — fully generic version
 *   6. Stream API chain — most idiomatic modern Java
 *
 * Note: Person.getAge() and printPerson() are stubs returning 0 / doing nothing.
 * The roster list is populated with sample data so output is visible.
 */
public class LambdaEvolutionExample {

    // -------------------------------------------------------------------------
    // Custom functional interfaces (pre-java.util.function era)
    // -------------------------------------------------------------------------

    /**
     * Custom Predicate — equivalent to java.util.function.Predicate<T>.
     * Defined here to show how lambdas work with any single-method interface.
     */
    interface Predicate<T> {
        boolean test(T t);
    }

    // -------------------------------------------------------------------------
    // Step 1: Named class — most explicit, zero reuse
    // -------------------------------------------------------------------------

    static class CheckPersonEligibleForService implements Predicate<Person> {
        @Override
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25;
        }
    }

    // -------------------------------------------------------------------------
    // Helper methods showing different abstraction levels
    // -------------------------------------------------------------------------

    /** Step 2: accepts any Predicate — replaced by lambda at the call site */
    public static void printPersons(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /** Step 3: adds a Consumer so the action is also parameterized */
    public static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    /** Step 4: adds a Function to transform the filtered element before consuming */
    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    /** Step 5: fully generic — works for any source type X producing any result Y */
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> roster = buildRoster();

        System.out.println("=== Step 1: Named class ===");
        printPersons(roster, new CheckPersonEligibleForService());

        System.out.println("\n=== Step 2: Lambda as Predicate ===");
        printPersons(roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25);

        System.out.println("\n=== Step 3: Predicate + Consumer lambdas ===");
        processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                p -> p.printPerson());

        System.out.println("\n=== Step 4: Predicate + Function + Consumer ===");
        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE,
                p -> p.getEmailAddress(),
                email -> System.out.println(email));

        System.out.println("\n=== Step 5: Fully generic processElements ===");
        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE,
                p -> p.getEmailAddress(),
                email -> System.out.println(email));

        System.out.println("\n=== Step 6: Stream API (most idiomatic) ===");
        roster.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }

    /** Builds a sample roster for demonstration purposes. */
    private static List<Person> buildRoster() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice", LocalDate.of(2000, 1, 1), Person.Sex.FEMALE, "alice@example.com"));
        list.add(new Person("Bob", LocalDate.of(2002, 5, 15), Person.Sex.MALE, "bob@example.com"));
        list.add(new Person("Charlie", LocalDate.of(1998, 3, 20), Person.Sex.MALE, "charlie@example.com"));
        list.add(new Person("Diana", LocalDate.of(2003, 7, 9), Person.Sex.FEMALE, "diana@example.com"));
        return list;
    }
}

/** Represents a person — the data class used throughout the lambda examples. */
class Person {
    public enum Sex { MALE, FEMALE }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public String getName() { return name; }
    public Sex getGender() { return gender; }
    public String getEmailAddress() { return emailAddress; }

    public void printPerson() {
        System.out.println(name + " (" + gender + ", age " + getAge() + ")");
    }
}
