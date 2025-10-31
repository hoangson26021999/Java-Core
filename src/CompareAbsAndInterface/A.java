package CompareAbsAndInterface;

public interface A {
    String getName();
    String getAuthor();
    default String getStaticString() {
        return A.class.getSimpleName();
    }
}
