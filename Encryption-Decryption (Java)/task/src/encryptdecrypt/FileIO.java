package encryptdecrypt;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class FileIO implements IO {

    private final String fileName;

    public FileIO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getInput() {
        try (Scanner in = new Scanner(new FileReader("filename.txt"));) {
            StringBuilder sb = new StringBuilder();
            while(in.hasNext()) {
                sb.append(in.next());
            }
            in.close();
            return sb.toString();
        } catch (IOException ioException) {
            throw new JustException("", ioException);
        }

    }

    @Override
    public void print(String string) {
        try (FileWriter fileWriter = new FileWriter(fileName);) {
            fileWriter.write(string);
        } catch (IOException ioException) {
            throw new JustException("", ioException);
        }

    }

}
