public class MyLinkedList<T> implements List<T> {
    private int size = 0;

    Node<T> first = new Node<>();
    Node<T> last = new Node<>();

    private static class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {

        Node<T> node = new Node<>();
        node.value = element;

        if (first.next == null) {
            first.next = node;
            last.prev = node;
        } else {
            Node<T> l = last;
            l.prev.next = node;
            node.prev = l.prev;
            l.prev = node;
        }

        size++;
    }

    @Override
    public void addByIndex(T element, int index) {
        if ((index == 0 && index == size) || (index == size && index > 0)) {
            add(element);
            return;
        }

        Node<T> newNode = new Node<>();
        newNode.value = element;

        Node<T> currentNode = getNodeByIndex(index);

        if (index == 0 && size > 0) {
            first.next = newNode;
            newNode.prev = first;
        } else {
            Node<T> prev = currentNode.prev;
            prev.next = newNode;
            newNode.prev = prev;
        }

        newNode.next = currentNode;

        currentNode.prev = newNode;

        size++;
    }

    @Override
    public T getByIndex(int index) {
        Node<T> currentNode = getNodeByIndex(index);

        return currentNode.value;
    }

    @Override
    public T removeByIndex(int index) {
        Node<T> nodeByIndex = getNodeByIndex(index);

        Node<T> prev = nodeByIndex.prev;
        Node<T> next = nodeByIndex.next;

        if (index == 0) {
            first.next = next;
        } else {
            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
            }
        }

        size--;

        return nodeByIndex.value;
    }

    private Node<T> getNodeByIndex (int index) {
        if (index < 0) {
            throw new MyIndexOutBoundsException("Index must be > 0");
        }

        if (index > size) {
            throw new MyIndexOutBoundsException("Index must be < " + size + " and > 0");
        }

        if (index == 0) {
            return first.next;
        }

        Node<T> currentNode = first.next;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    @Override
    public void clear() {
        size = 0;
        first = new Node<>();
        last = new Node<>();
    }

    @Override
    public String toString() {
        String str = "List : [";

        if (first.next != null) {
            Node<T> currentNode = first.next;

            for (int i = 0; i < size; i++) {
                str = str + currentNode.value + ", ";
                currentNode = currentNode.next;
            }

            str = str.substring(0, str.length() - 2);
        }

        str = str + "]";

        return str;
    }
}

