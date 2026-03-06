package step6_cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import step6_cli.LogFormat.Log;
import step6_cli.LogFormat.Ope;

public class LogReader {
    /**
     * Fileを受け取ってOptional<List<Log>>を返す
     */
    public static Optional<List<Log>> readFile(File file) {
        try (var sc = new Scanner(file)) {

            var logs = new ArrayList<Log>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // Assuming each line is in the format "name operation"
                String[] parts = line.split(" "); // Split by space
                if (parts.length == 2) {
                    String name = parts[0];
                    Ope ope = Ope.operation(parts[1]);
                    logs.add(new Log(name, ope));
                }
            }
            return Optional.of(logs);

        } catch (FileNotFoundException e) {
            return Optional.empty();
        }
    }
}
