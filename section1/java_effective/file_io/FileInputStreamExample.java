package section1.java_effective.file_io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class FileInputStreamExample {
    public static void main(String[] args) throws Exception {
        try {
            // BufferedInputStream이라는 보조 스트림을 사용하면 성능이 향상되기 때문에, 대부분의 경우 이를 사용합니다.
            // 버퍼란 바이트 배열로서, 여러 바이트를 저장하여 한 번에 많은 양의 데이터를 입출력할 수 있도록 도와주는 임시 저장 공간입니다.
            FileInputStream fileInput = new FileInputStream("section1/java_effective/file_io/hello.txt");
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);

            int i = 0;
            //fileInput.read()의 리턴값을 i에 저장한 후, 값이 -1인지 확인합니다.
            while ((i = fileInput.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}