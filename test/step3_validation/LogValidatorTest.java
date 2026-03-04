package step3_validation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LogValidatorTest {

    /** 正常ケース：LOGIN → LOGOUT */
    @Test
    void testValidLogs() {
        List<String> logs = List.of("LOGIN", "LOGOUT");
        assertDoesNotThrow(() -> LogValidator.validate(logs));
    }

    /** LOGIN の後に LOGOUT が無いケース */
    @Test
    void testMissingLogout() {
        List<String> logs = List.of("LOGIN");
        assertThrows(IllegalStateException.class,
                () -> LogValidator.validate(logs));
    }

    /** LOGOUT のみは異常 */
    @Test
    void testLogoutOnly() {
        List<String> logs = List.of("LOGOUT");
        assertThrows(IllegalStateException.class,
                () -> LogValidator.validate(logs));
    }

    /** LOGIN → LOGIN は異常（重複） */
    @Test
    void testDuplicateLogin() {
        List<String> logs = List.of("LOGIN", "LOGIN");
        assertThrows(IllegalStateException.class,
                () -> LogValidator.validate(logs));
    }

    /** 不明なログが来たら異常 */
    @Test
    void testUnknownLog() {
        List<String> logs = List.of("LOGIN", "HELLO", "LOGOUT");
        assertThrows(IllegalStateException.class,
                () -> LogValidator.validate(logs));
    }
}