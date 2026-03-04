package step4_refactor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LogReader {
    /**
     * Fileを受け取ってOptional<List<String>>を返す
     */
    public static Optional<List<String>> readFile(File file) {
        try (var sc = new Scanner(file)) {

            var logs = new ArrayList<String>();
            while (sc.hasNextLine()) {
                logs.add(sc.nextLine());
            }
            return Optional.of(logs);

        } catch (FileNotFoundException e) {
            return Optional.empty();
        }
    }
}
