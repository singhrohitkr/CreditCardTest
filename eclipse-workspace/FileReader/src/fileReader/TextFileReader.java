package fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextFileReader {
    public static void main(String[] args) throws IOException {
        Stream<String> input = Files.lines(Paths.get("D://Downloads//test.txt"));
        input.forEach(System.out::println);

    }

}
