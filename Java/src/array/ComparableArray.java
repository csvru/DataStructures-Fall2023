package array;

public class ComparableArray<T extends Comparable<T>> extends Array<T> implements IComparableArray<T>{
    public ComparableArray(int length, T defaultValue) {
        super(length, defaultValue);
    }

    @Override
    public int findInsertIndex(T value) {
        return 0;
    }

    @Override
    public T findMax() {
        if (super.length() == 0) {
            return null;
        }
        var maximum = super.get(0);
        for(var counter = 1; counter < super.length(); counter++){
            var currentItem = super.get(counter);
            if(currentItem.compareTo(maximum) > 0) {
                maximum = currentItem;
            }
        }
        return maximum;
    }
}
