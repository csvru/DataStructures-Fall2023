package array;

public interface IComparableArray<T extends Comparable<T>> {
    int findInsertIndex(T value);
    T findMax();
}
