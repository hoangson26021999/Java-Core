package generics;

/**
 * Defines a generic interface for write operations.
 *
 * Key concept:
 *   - A generic interface uses a type parameter T so the same interface
 *     can be used for any type (String, Integer, a domain object, etc.)
 *   - Implementing classes specify the concrete type: class BookImpl implements Writer<Book>
 */
public interface WriterInterface<T> {
    void update(T obj);
    void delete(T obj);
    void write(T obj);
}
