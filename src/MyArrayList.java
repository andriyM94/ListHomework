import java.util.Arrays;

public class MyArrayList<T> implements List<T> {

    private final static int START_CAPACITY = 10;

    private int capacity = 10;
    private int size = 0;

    private Object[] array = new Object[capacity];

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
        checkIndex(index);

        if (index == size) {
            add(element);
            return;
        }

        checkCapacity();

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = element;

        size++;
    }

    private void checkIndex(int index) {
        if (index < 0) {
            throw new RuntimeException("Index can not be negative");
        }

        if (index > size) {
            throw new MyIndexOutBoundsException("Index (" + index + ") can not be better for size(" + size + ")");
        }
    }

    @Override
    public T getByIndex(int index) {
        checkIndex(index);

        return (T) array[index];
    }

    @Override
    public T removeByIndex(int index) {

        T element = getByIndex(index);

        if (index == size - 1) {
            array[index] = null;
        } else {
            System.arraycopy(array, index + 1, array, index, size - index);
        }

        size--;

        return element;
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

        if (size != 0) {
            for (int i = 0; i < size; i++) {
                str = str + array[i] + ", ";
            }

            str = str.substring(0, str.length() - 2);
        }

        str = str + "]";

        return str;
    }
}
