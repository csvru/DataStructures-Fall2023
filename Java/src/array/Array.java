package array;

import java.util.Arrays;

public class Array<T> implements IArray<T> {
    private final T[] data;
    private final T defaultValue;

    public Array(int length) {
        this(length, null);
    }
    @SuppressWarnings("unchecked")
    public Array(int length, T defaultValue) {
        this.data = (T[]) new Comparable[length];
        this.defaultValue = defaultValue;
        Arrays.fill(this.data, defaultValue);
    }

    @Override
    public Integer indexOf(T query) {
        for (int index = 0; index < this.length(); index++) {
            if (this.get(index).equals(query)) {
                return index;
            }
        }
        return null;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.data.length) {
            var errorMessage = String.format("out of bound. index must be between 0 and %d", this.data.length);
            throw new IndexOutOfBoundsException(errorMessage);
        }
        return this.data[index];
    }

    @Override
    public IArray<T> set(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.data.length) {
            var errorMessage = String.format("out of bound. index must be between 0 and %d", this.data.length);
            throw new IndexOutOfBoundsException(errorMessage);
        }
        this.data[index] = value;
        return this;
    }

    @Override
    public IArray<T> shiftToRight(int from) throws IndexOutOfBoundsException {
        if (from < 0 || from >= this.data.length - 1) {
            var upperBound = this.data.length - 1;
            var errorMessage = String.format("out of bound. from must be between 0 and %d", upperBound);
            throw new IndexOutOfBoundsException(errorMessage);
        }
        for (var counter = this.data.length - 1; counter > from; counter--) {
            this.data[counter] = this.data[counter - 1];
        }
        this.data[from] = this.defaultValue;
        return this;
    }

    @Override
    public int length() {
        return this.data.length;
    }

    @Override
    public T getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }
}
