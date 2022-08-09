import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaders {

    public List<String> readWordsFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("files/Words.txt").getFile());
        Path path = Paths.get(file.getPath());

        List<String> allWords = new ArrayList<>();

        try {
            Stream<String> fileLines = Files.lines(path);
            allWords = fileLines.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("File doesn't exist");
        }

        return allWords;

    }
}