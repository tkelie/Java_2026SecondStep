package step1_junit;

public class FizzBuzz {

    /**
     * FizzBuzz 判定メソッド
     *
     * @param n 判定対象の整数
     * @return "Fizz" / "Buzz" / "FizzBuzz" / 数字（文字列）
     */
    public static String fizzBuzz(int n) {

        if (n % 15 == 0) {
            return "FizzBuzz";
        }
        if (n % 3 == 0) {
            return "Fizz";
        }
        if (n % 5 == 0) {
            return "Buzz";
        }

        return String.valueOf(n);
    }
}