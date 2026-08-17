package generics;

/**
 * Demonstrates a generic class implementing a generic interface.
 *
 * Key concepts:
 *   - When a generic class implements a generic interface, it passes
 *     the type parameter through: class BookRepository<T> implements WriterInterface<T>
 *   - The concrete type is still deferred to the use site:
 *     new BookRepository<String>() → T becomes String everywhere.
 *
 * This pattern is common in repository/data-access layers where the
 * same CRUD interface applies to different entity types.
 */
public class GenericInterfaceExample {

    /**
     * A generic repository for any type T, implementing the WriterInterface contract.
     *
     * @param <T> the entity type this repository manages
     */
    static class BookRepository<T> implements WriterInterface<T> {

        @Override
        public void update(T obj) {
            System.out.println("Updating: " + obj);
        }

        @Override
        public void delete(T obj) {
            System.out.println("Deleting: " + obj);
        }

        @Override
        public void write(T obj) {
            System.out.println("Writing: " + obj);
        }
    }

    public static void main(String[] args) {
        // T is resolved to String at the use site
        BookRepository<String> stringRepo = new BookRepository<>();
        stringRepo.write("Clean Code");
        stringRepo.update("Refactoring");
        stringRepo.delete("Old Book");

        // T is resolved to Integer
        BookRepository<Integer> intRepo = new BookRepository<>();
        intRepo.write(42);
    }
}
