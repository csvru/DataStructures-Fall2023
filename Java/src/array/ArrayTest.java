package array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class ArrayTest {
    @Test
    @DisplayName("init with length")
    void initialArrayWithLength() {
        var length = 20;
        var actualArray = new Array<Integer>(length);
        assertEquals(Arrays.toString(new Object[length]), actualArray.toString());
    }
    @Test
    @DisplayName("init with default integer")
    void initialArrayWithLengthAndDefaultValueInteger() {
        var length = 20;
        var actualArray = new Array<>(length, 0);
        assertEquals(Arrays.toString(new int[length]), actualArray.toString());
    }
    @Test
    @DisplayName("init with default float")
    void initialArrayWithLengthAndDefaultValueFloat() {
        var length = 20;
        var actualArray = new Array<>(length, 0.0);
        assertEquals(Arrays.toString(new float[length]), actualArray.toString());
    }
}
