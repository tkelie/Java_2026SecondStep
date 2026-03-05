package step5_grouping;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import step5_grouping.LogFormat.Log;

class UserFinderTest {

    @Test
    void testFindRepeatedUsers() {

        List<Log> logs = List.of(
                new Log("Alice", LogFormat.Ope.LOGIN),
                new Log("Bob", LogFormat.Ope.LOGIN),
                new Log("Alice", LogFormat.Ope.LOGOUT),
                new Log("Alice", LogFormat.Ope.LOGIN),
                new Log("Bob", LogFormat.Ope.LOGOUT),
                new Log("Alice", LogFormat.Ope.LOGIN)
        );

        List<String> result = UserFinder.findRepeatedUsers(logs);

        assertEquals(List.of("Alice"), result);
    }

    @Test
    void testNoRepeatedUsers() {

        List<Log> logs = List.of(
                new Log("Alice", LogFormat.Ope.LOGIN),
                new Log("Alice", LogFormat.Ope.LOGOUT),
                new Log("Bob", LogFormat.Ope.LOGIN),
                new Log("Bob", LogFormat.Ope.LOGOUT)
        );

        List<String> result = UserFinder.findRepeatedUsers(logs);

        assertTrue(result.isEmpty());
    }
}