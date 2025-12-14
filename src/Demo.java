public class Demo {
    public static void main(String[] args) {
    // test MyArrayList
        MyArrayList<String> strings = new MyArrayList<>();

        strings.addByIndex("0 test", 0);
        strings.add("1 test");
        strings.addByIndex("2 test", 2);
        strings.addByIndex("null", 0);

        System.out.println("Element by index 1 : " + strings.getByIndex(1));
        System.out.println("MyArrayList : " + strings);
        System.out.println("Size before clear: " + strings.size());
        strings.clear();
        System.out.println("Size after clear: " + strings.size());
        System.out.println("MyArrayList : " + strings);

        System.out.println("-".repeat(50));

    //test MyLinkedList
        MyLinkedList<String> list = new MyLinkedList<>();

        list.addByIndex("0 test", 0);
        list.add("1 test");
        list.addByIndex("2 test", 2);

        System.out.println(list.size());

        System.out.println("Element by index 1 : " + list.getByIndex(1));
        System.out.println("MyLinkedList : " + list);
        System.out.println("Size before clear: " + list.size());
        list.clear();
        System.out.println("Size after clear: " + list.size());
        System.out.println("MyLinkedList : " + list);
    }
}
