package step5_grouping;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import step5_grouping.LogFormat.Log;

class LogReaderTest {

    @Test
    void testReadFileSuccess() {

        File file = new File("samplefile/step5.txt");

        Optional<List<Log>> result = LogReader.readFile(file);

        assertTrue(result.isPresent());

        List<Log> logs = result.get();

        assertFalse(logs.isEmpty());
    }

    @Test
    void testFileNotFound() {

        File file = new File("samplefile/not_exist.txt");

        Optional<List<Log>> result = LogReader.readFile(file);

        assertTrue(result.isEmpty());
    }
}