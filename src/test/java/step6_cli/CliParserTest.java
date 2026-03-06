package step6_cli;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class CliParserTest {

    @Test
    void parse_shouldReturnFilePath() {

        Map<String, String> result = CliParser.parse(new String[] { "--file", "samplefile/step5.txt" });

        assertEquals("samplefile/step5.txt", result.get("--file"));
    }

    @Test
    void parse_shouldReturnOptionFlag() {

        Map<String, String> result = CliParser.parse(new String[] { "--summary" });

        assertEquals("true", result.get("--summary"));
    }

    @Test
    void parse_shouldParseFileAndOption() {

        Map<String, String> result = CliParser.parse(new String[] {
                "--file", "samplefile/step5.txt",
                "--summary"
        });

        assertEquals("samplefile/step5.txt", result.get("--file"));
        assertEquals("true", result.get("--summary"));
    }

    @Test
    void parse_shouldReturnEmptyMap_whenArgsEmpty() {

        Map<String, String> result = CliParser.parse(new String[] {});

        assertEquals(0, result.size());
    }

    @Test
    void parse_shouldHandleMultipleOptions() {

        Map<String, String> result = CliParser.parse(new String[] {
                "--file", "a.txt",
                "--summary",
                "--duplicate"
        });

        assertEquals("a.txt", result.get("--file"));
        assertEquals("true", result.get("--summary"));
        assertEquals("true", result.get("--duplicate"));
    }

    @Test
    void parse_shouldDetectHelpOption() {

        Map<String, String> result = CliParser.parse(new String[] { "--help" });

        assertEquals("true", result.get("--help"));
    }
}