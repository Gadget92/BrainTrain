package solutions.alternative;

import solutions.alternative.linklist.MyLinkedList;

public class Main {

    public static void main(String[] args) {

        myLinkedListTest();

    }

    private static void myLinkedListTest() {
        MyLinkedList linkedList = new MyLinkedList();

        System.out.println("Created new list: " + linkedList);

        linkedList.addValue(10);

        System.out.println("Added value 10 to list: " + linkedList);

        linkedList.addValue(5);

        System.out.println("Added value 5 to list: " + linkedList);

        linkedList.insertValue(0, 0);

        linkedList.insertValue(100, linkedList.getSize());

        linkedList.insertValue(999, 1);

        System.out.println("Inserted value 0 to first position, value 100 to last position and 999 to position 1: " + linkedList);

        System.out.println("Value at HEAD = " + linkedList.getHead().getNodeValue());

        System.out.println("Value at TAIL = " + linkedList.getTail().getNodeValue());

        System.out.println("Value at position 3 = " + linkedList.getValueAt(3));

        System.out.println("Value at position 4 = " + linkedList.getValueAt(4));

        linkedList.delete(0);

        System.out.println("Deleted first element: " + linkedList);

        linkedList.delete(linkedList.getSize() - 1);

        System.out.println("Deleted last element: " + linkedList);

        linkedList.delete(1);

        System.out.println("Deleted second element: " + linkedList);

        linkedList.clear();

        System.out.println("Cleared list: " + linkedList);
    }

}
