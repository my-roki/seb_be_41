package section1.java_effective.file_io;

import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) throws Exception {
        try {
            FileOutputStream fileOutput = new FileOutputStream("section1/java_effective/file_io/bye.txt");
            String word = "Bye~";

            byte b[] = word.getBytes();
            fileOutput.write(b);
            fileOutput.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}