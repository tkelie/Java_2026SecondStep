package step2_exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayAverageTest {

    @Test
    void testAverageNormal() {
        int[] values = {2, 4, 6, 8};
        double result = ArrayAverage.average(values);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    void testEmptyArray() {
        int[] empty = {};
        assertThrows(IllegalArgumentException.class,
                () -> ArrayAverage.average(empty));
    }

    @Test
    void testNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> ArrayAverage.average(null));
    }
}