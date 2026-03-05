package step5_grouping;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

import step5_grouping.LogFormat.Log;

class IntegrationTest {

    @Test
    void testFindRepeatedUsersFromFile() {

        File file = new File("samplefile/step5.txt");

        var logsOpt = LogReader.readFile(file);

        assertTrue(logsOpt.isPresent());

        List<Log> logs = logsOpt.get();

        List<String> result = UserFinder.findRepeatedUsers(logs);

        assertEquals(List.of("Alice"), result);
    }

}
