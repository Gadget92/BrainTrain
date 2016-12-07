package solutions.alternative.linklist;


public class MyLinkedList {
    private ListNode head = null;
    private ListNode tail = null;

    private int size = 0;

    public void addValue(int value) {
        ListNode newNode = new ListNode(value);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            ListNode lastNode = tail;
            lastNode.setNextNode(newNode);

            tail = newNode;
            tail.setPreviousNode(lastNode);
        }
    }

    public ListNode getTail() {
        return tail;
    }

    public ListNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }
}
