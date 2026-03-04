package step4_refactor;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        var file = new File("samplefile/step4.txt");

        LogReader.readFile(file) // Optional<List<String>>
                .ifPresentOrElse(

                        logs -> { // --- ★ ある場合 --- //
                            try {
                                int count = SessionAnalyzer.countSessions(logs);
                                System.out.println("セッション数: " + count);
                            } catch (IllegalStateException e) {
                                System.err.println("ログ形式エラー: " + e.getMessage());
                            }
                        },

                        () -> { // --- ★ 無い場合 --- //
                            System.err.println("ファイルが見つかりませんでした");
                        });
    }
}