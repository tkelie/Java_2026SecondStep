package step4_refactor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class LogReaderOptionalTest {

    // 正常系：ファイルを正しく読み込める
    @Test
    void testReadFile_normalCase() throws IOException {

        // --- テスト用のファイルを一時作成 ---
        File temp = File.createTempFile("logtest", ".txt");
        Files.writeString(temp.toPath(), "LOGIN\nLOGOUT\n");

        Optional<List<String>> result = LogReader.readFile(temp);

        assertTrue(result.isPresent());
        assertEquals(2, result.get().size());
        assertEquals("LOGIN", result.get().get(0));
        assertEquals("LOGOUT", result.get().get(1));
    }

    // 空ファイル：空リスト入り Optional
    @Test
    void testReadFile_emptyFile() throws IOException {

        File temp = File.createTempFile("logtest_empty", ".txt");
        // 空でOK

        Optional<List<String>> result = LogReader.readFile(temp);

        assertTrue(result.isPresent());
        assertTrue(result.get().isEmpty());
    }

    // 存在しないファイル：Optional.empty()
    @Test
    void testReadFile_fileNotFound() {

        File notExists = new File("no_such_file_9999.txt");

        Optional<List<String>> result = LogReader.readFile(notExists);

        assertTrue(result.isEmpty());
    }
}