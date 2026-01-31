package junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.File;
import java.io.IOException;

public class FileProcessorTest {
    
    private FileProcessor fileProcessor = new FileProcessor();
    private String testFile = "test.txt";
    
    @AfterEach
    public void cleanup() {
        new File(testFile).delete();
    }
    
    @Test
    public void testWriteAndReadFile() throws IOException {
        String content = "Hello World";
        fileProcessor.writeToFile(testFile, content);
        
        assertTrue(new File(testFile).exists());
        assertEquals(content, fileProcessor.readFromFile(testFile));
    }
    
    @Test
    public void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("nonexistent.txt");
        });
    }
}