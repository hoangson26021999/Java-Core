package Lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

interface Predicate<Person> {
    boolean test(Person t);
}

class CheckPersonEligibleForSelectiveService implements Predicate<Person> {
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25;
    }
}

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
        return 0 ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void printPerson() {
        // ...
    }

    public static void printPersons(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }
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

    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function <X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }


    public static void main (String[] args) {

        List<Person> roster = new ArrayList<>();
        Person.printPersons(roster, (Person p) ->
                 p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25

        );
        Person.processPersons(
                roster ,
                (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25  ,
                (Person a) -> a.printPerson()  );

        Person.processPersonsWithFunction(
                roster ,
                p -> p.getGender() == Person.Sex.MALE ,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        Person.processElements(
                roster,
                p -> p.getName() == "aaaa",
                p -> p.getAge(),
                email -> System.out.println(email));

        roster
                .stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));

    }
}
