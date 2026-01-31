package junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {
    
    private NumberUtils numberUtils = new NumberUtils();
    
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEvenTrue(int number) {
        assertTrue(numberUtils.isEven(number));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void testIsEvenFalse(int number) {
        assertFalse(numberUtils.isEven(number));
    }
}