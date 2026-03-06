package step6_cli;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import step6_cli.LogFormat.Log;
import step6_cli.LogFormat.Ope;

public class LogCounter {
    /**
     * ログのリストを受け取って、ユーザーごとのログイン回数をカウント
     * Map<String, Long>で返す
     */
    public static Map<String, Long> countLogins(List<Log> logs) {

        return logs.stream()
                .filter(log -> log.ope() == Ope.LOGIN)
                .collect(Collectors.groupingBy(
                        Log::name,
                        Collectors.counting()));
    }
}
