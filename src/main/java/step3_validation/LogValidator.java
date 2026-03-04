package step3_validation;

import java.util.List;

public class LogValidator {

    /**
     * LOGIN と LOGOUT のペアが正しいか検証する
     * 問題があれば IllegalStateException を投げる
     */
    public static void validate(List<String> logs) {

        boolean inSession = false;

        for (String log : logs) {
            switch (log) {

                case "LOGIN":
                    if (inSession) {
                        throw new IllegalStateException("LOGIN 重複エラー");
                    }
                    inSession = true;
                    break;

                case "LOGOUT":
                    if (!inSession) {
                        throw new IllegalStateException("LOGOUT の位置が不正");
                    }
                    inSession = false;
                    break;

                default:
                    throw new IllegalStateException("未知のログ: " + log);
            }
        }

        if (inSession) {
            throw new IllegalStateException("LOGOUT 欠落エラー");
        }
    }
}