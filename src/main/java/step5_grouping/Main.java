package step5_grouping;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        var file = new File("samplefile/step5.txt");

        var logsOpt = LogReader.readFile(file); // Optional<List<Log>>

        if (logsOpt.isEmpty()) {
            System.err.println("ファイルが見つかりません");
            return;
        }

        var logs = logsOpt.get();

        // LOGIN回数
        System.out.println("=== LOGIN回数 ===");

        Map<String, Long> counts = LogCounter.countLogins(logs);

        counts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                        System.out.println(e.getKey() + " : " + e.getValue()));

        // 重複ユーザー
        System.out.println("\n=== 重複LOGINユーザー ===");

        List<String> repeated = UserFinder.findRepeatedUsers(logs);
        repeated.forEach(System.out::println);
    }
}