package array.sorted;

import array.Array;
import array.IComparableArray;

public class SortedArray<T extends Comparable<T>> extends Array<T> implements IComparableArray<T> {
    public SortedArray(int length, T defaultValue) {
        super(length, defaultValue);
    }

    @Override
    public Integer indexOf(T query) {
        int low = 0, high = super.length() - 1;
        while (low <= high) {
            var midIndex = (high + low) / 2;
            var midValue = super.get(midIndex);
            if (midValue.compareTo(query) == 0) {
                return midIndex;
            }
            else if (midValue.compareTo(query) > 0) {
                high = midIndex - 1;
            } else {
                low = midIndex + 1;
            }
        }
        return null;
    }

    @Override
    public int findInsertIndex(T value) {
        int low = 0, high = super.length() - 1;
        while (low <= high) {
            var midIndex = (high + low) / 2;
            var midValue = super.get(midIndex);
            if (midValue.compareTo(value) == 0) {
                return midIndex;
            } else if (super.getDefaultValue().compareTo(midValue) == 0) {
                high = midIndex - 1;
            } else if (midValue.compareTo(value) > 0) {
                high = midIndex - 1;
            } else {
                low = midIndex + 1;
            }
        }
        return low;
    }

    @Override
    public T findMax() {
        return super.get(super.length() - 1);
    }
}
