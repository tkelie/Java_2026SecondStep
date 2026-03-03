package step2_exception;

public class ArrayAverage {

    /**
     * 配列の平均値を返す
     *
     * @param values int配列
     * @return 平均値 (double)
     * @throws IllegalArgumentException 空配列または null の場合
     */
    public static double average(int[] values) {

        if (values == null) {
            throw new IllegalArgumentException("values is null");
        }
        if (values.length == 0) {
            throw new IllegalArgumentException("values is empty");
        }

        int sum = 0;
        for (int v : values) {
            sum += v;
        }

        return (double) sum / values.length;
    }
}