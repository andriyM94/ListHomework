public interface List<E>  {
    int size();

    void add(E element);

    void addByIndex(E element, int index);

    E getByIndex(int index);

    void clear();
}
