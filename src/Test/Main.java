package Test;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String longStr = generateLongString(16000);
        int chunkSize = 3000;
        int length = longStr.length();
        IntStream.range(0, (length + chunkSize - 1) / chunkSize) // số lần chia
                .mapToObj(i -> {
                    int start = i * chunkSize;
                    int end = Math.min(start + chunkSize, length);
                    return longStr.substring(start, end);
                })
                .forEach(Main::A);
    }

    public static void A(String s) {
        System.out.println("Chunk of size: " + s.length());
    }

    public static String generateLongString(int len) {
        return new String(new char[len]).replace('\0', 'x'); // tạo chuỗi 'xxxxx...'
    }
}
