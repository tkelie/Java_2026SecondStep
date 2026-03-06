package step6_cli;

import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> opt = CliParser.parse(args);

        if (opt.containsKey("--help")) {
            printHelp();
            return;
        }
        
        String filePath = opt.get("--file");

        if (filePath == null) {
            System.out.println("Usage: --file <logfile> [--summary | --duplicate]");
            return;
        }

        var logs = LogReader.readFile(new File(filePath));

        if (logs.isEmpty()) {
            System.err.println("ファイルが見つかりません: " + filePath);
            return;
        }

        if (opt.containsKey("--summary")) {
            LogCounter.countLogins(logs.get())
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        } else if (opt.containsKey("--duplicate")) {
            UserFinder.findRepeatedUsers(logs.get())
                    .forEach(System.out::println);

        } else {
            System.out.println("mode required: --summary or --duplicate");
        }
    }

    private static void printHelp() {

        System.out.println("Log Analyzer CLI");
        System.out.println();
        System.out.println("Usage:");
        System.out.println("  --file <path>      ログファイルを指定");
        System.out.println("  --summary          ユーザー別 LOGIN 回数を表示");
        System.out.println("  --duplicate        LOGIN が複数回あるユーザーを表示");
        System.out.println("  --help             このヘルプを表示");
    }
}