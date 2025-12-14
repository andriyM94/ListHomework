import java.util.Arrays;

public class MyArrayList<T> implements List<T> {

    private final static int START_CAPACITY = 10;

    private int capacity = 10;
    public int size = 0;

    public Object[] array = new Object[capacity];

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {

        checkCapacity();

        array[size] = element;

        size++;
    }

    @Override
    public void addByIndex(T element, int index) {
        if (index < 0) {
            throw new RuntimeException("Index can not be negative");
        }

        if (index > size) {
            throw new RuntimeException("Index can not be better for size");
        }

        checkCapacity();

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = element;
    }

    @Override
    public T getByIndex(int index) {
        return (T) array[index];
    }

    @Override
    public void clear() {
        capacity = START_CAPACITY;
        size = 0;
        array = new Object[capacity];
    }

    private void checkCapacity() {
        if (size + 1 > capacity) {
            capacity = (int)(capacity * 1.5);
            array = Arrays.copyOf(array, capacity);
        }
    }

    @Override
    public String toString() {
        String str = "[";

        for (int i = 0; i < size; i++) {
            str = str + array[i] + ", ";
        }

        str = str.substring(0, str.length() - 2);

        str = str + "]";

        return str;
    }
}
