package Exception;

public class Finally{
    public static void main(String[] args) {
        try {
            System.out.println("Trong try");
            int a = 5 / 0; // Gây ra ArithmeticException
        } catch (Exception e) {
            System.out.println("Trong catch: " + e.getMessage());
            throw new RuntimeException("Lỗi trong catch"); // Ném tiếp exception
        } finally {
            System.out.println("Khối finally luôn được thực thi!");
        }
    }
}

