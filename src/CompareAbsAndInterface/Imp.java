package CompareAbsAndInterface;

public class Imp implements A , B{
    @Override
    public String getName() {
        return "Name";
    }

    @Override
    public String getAuthor() {
        return "Son";
    }

    /**
     * Nếu như 2 interface có phương thức default giống nhau thì lớp con phải chỉ định rõ ràng ( tự implement ) hàm đó
     * @return
     */
    @Override
    public String getStaticString() {
        return "Hihi";
    }

    @Override
    public int getAge() {
        return 0;
    }
    public static void main(String[] args) {
        Imp imp = new Imp();
        System.out.println(imp.getName());
        System.out.println(imp.getStaticString());
        System.out.println(imp.getB());
    }
}
