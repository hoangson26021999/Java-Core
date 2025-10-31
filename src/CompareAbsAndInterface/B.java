package CompareAbsAndInterface;

public interface B {
    String getName();
    String getAuthor();
    int getAge();
    default String getStaticString() {
        return B.class.getSimpleName();
    }
    default String getB() {
        return "B";
    }
}
