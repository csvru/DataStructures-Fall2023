package array;

public interface IArray<T> {
    Integer indexOf(T query);
    T get(int index);
    @SuppressWarnings("UnusedReturnValue")
    IArray<T> set(int index, T value);
    IArray<T> shiftToRight(int from);
    int length();
    T getDefaultValue();
}
