package junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.time.Duration;

public class TaskRunnerTest {
    
    private TaskRunner taskRunner = new TaskRunner();
    
    @Test
    @Timeout(2)
    public void testLongRunningTaskTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            taskRunner.longRunningTask();
        });
    }
}