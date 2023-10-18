package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIO implements IO {

    private final String fileName;

    public FileIO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getInput() {
        try   {
            Path path = Paths.get(fileName);
             return Files.readString(path);

        } catch (IOException ioException) {
            throw new JustException("Error: reading file", ioException);
        }

    }

    @Override
    public void print(String string) {
        try (FileWriter fileWriter = new FileWriter( new File(fileName));) {
            fileWriter.write(string);
        } catch (IOException ioException) {
            throw new JustException("Error: writing to file", ioException);
        }

    }

}
