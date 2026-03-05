package step5_grouping;

public class LogFormat {

    // Log record
    public record Log(String name, Ope ope) {
    }

    // Operation
    public enum Ope {
        LOGIN, LOGOUT;

        static Ope operation(String op) {
            return switch (op) {
                case "LOGIN" -> LOGIN;
                case "LOGOUT" -> LOGOUT;
                default -> throw new IllegalArgumentException("unknown operation: " + op);
            };
        }
    }
}
