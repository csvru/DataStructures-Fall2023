package array.sorted;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class SortedArrayTest {
    @Test
    @DisplayName("test")
    void test() {
        var actualSortedArray = new SortedArray<>(10, 0);
        var p = actualSortedArray.findInsertIndex(5);
        actualSortedArray.set(p, 5);
        System.out.println(actualSortedArray);
        p = actualSortedArray.findInsertIndex(7);
        actualSortedArray.set(p, 7);
        System.out.println(actualSortedArray);
        System.out.println(actualSortedArray.findInsertIndex(6));
        System.out.println(actualSortedArray.shiftToRight(0));
    }
}
