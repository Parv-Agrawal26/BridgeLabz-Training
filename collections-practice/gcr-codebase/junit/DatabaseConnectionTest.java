package junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {
    
    private DatabaseConnection connection;
    
    @BeforeEach
    public void setUp() {
        connection = new DatabaseConnection();
        connection.connect();
    }
    
    @AfterEach
    public void tearDown() {
        connection.disconnect();
    }
    
    @Test
    public void testConnectionEstablished() {
        assertTrue(connection.isConnected());
    }
    
    @Test
    public void testConnectionActive() {
        assertTrue(connection.isConnected());
    }
}