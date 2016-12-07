package solutions.alternative.linklist;


public class MyLinkedList {
    private ListNode head = null;
    private ListNode tail = null;

    private int size = 0;

    public void addValue(int value) {
        ListNode newNode = new ListNode(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            ListNode lastNode = tail;
            lastNode.setNextNode(newNode);

            tail = newNode;
            tail.setPreviousNode(lastNode);
        }

        size += 1;
    }

    public void insertValue(int value, int position) {
        if ((position < 0) || (position > size)) {
            System.out.println(String.format(
                    "Can not insert value %d. Position %d is outside list range",
                    value,
                    position
            ));

            return;
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
