package Synchronise;

public class Singleton {

    // 1. Khai báo một biến static private của cùng class
    private static volatile Singleton instance;

    // 2. Khai báo constructor là private
    //    để ngăn chặn việc tạo instance từ bên ngoài
    private Singleton() {
        // Ngăn chặn việc tạo instance bằng reflection (có thể thêm logic kiểm tra)
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    // 3. Cung cấp một phương thức static public để lấy instance
    public static Singleton getInstance() {
        // Kiểm tra lần 1 (không đồng bộ hóa)
        if (instance == null) {
            // Khối đồng bộ hóa
            synchronized (Singleton.class) {
                // Kiểm tra lần 2 (đảm bảo chỉ tạo một lần)
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Các phương thức khác của lớp Singleton
    public void showMessage() {
        System.out.println("Hello, I am the single instance!");
    }
}
