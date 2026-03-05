package step5_grouping;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import step5_grouping.LogFormat.Log;

class LogCounterTest {

    @Test
    void testLoginCount() {

        List<Log> logs = List.of(
                new Log("Alice", LogFormat.Ope.LOGIN),
                new Log("Bob", LogFormat.Ope.LOGIN),
                new Log("Alice", LogFormat.Ope.LOGOUT),
                new Log("Alice", LogFormat.Ope.LOGIN),
                new Log("Bob", LogFormat.Ope.LOGOUT),
                new Log("Alice", LogFormat.Ope.LOGIN),
                new Log("Alice", LogFormat.Ope.LOGOUT),
                new Log("Alice", LogFormat.Ope.LOGIN));

        Map<String, Long> result = LogCounter.countLogins(logs);

        assertEquals(4L, result.get("Alice"));
        assertEquals(1L, result.get("Bob"));
    }
}