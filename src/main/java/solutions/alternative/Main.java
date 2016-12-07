package solutions.alternative;

import solutions.alternative.linklist.MyLinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addValue(10);
        linkedList.addValue(5);

        System.out.println(linkedList);
    }

}
