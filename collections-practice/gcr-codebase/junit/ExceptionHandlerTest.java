package junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionHandlerTest {
    
    private ExceptionHandler handler = new ExceptionHandler();
    
    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> handler.divide(10, 0));
    }
    
    @Test
    public void testDivideNormal() {
        assertEquals(5, handler.divide(10, 2));
    }
}