package step5_grouping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import step5_grouping.LogFormat.Log;
import step5_grouping.LogFormat.Ope;
/**
 * List<Log>を受け取って、ログイン回数が2回以上のユーザーの名前をList<String>で返す
 */
public class UserFinder {
    public static List<String> findRepeatedUsers(List<Log> list) {

        return list.stream()
                .filter(log -> log.ope() == Ope.LOGIN)
                .collect(Collectors.groupingBy(Log::name, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
    }
}
