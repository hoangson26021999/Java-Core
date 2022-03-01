package Exception;

import java.io.IOException;

public class CheckedException {
    void except () throws IOException {
        
    }
    public static void main(String[] args) {
        int age = 11 ;
        if( age < 18) {
            System.out.println("Ban chua du tuoi!");
            throw new ArithmeticException() ;
        }
    }
}
