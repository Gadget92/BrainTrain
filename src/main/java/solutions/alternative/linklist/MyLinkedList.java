package solutions.alternative.linklist;

public class MyLinkedList<T> {
    private ListNode<T> head = null;
    private ListNode<T> tail = null;

    private int size = 0;

    public void addValue(T value) {
        ListNode<T> newNode = new ListNode<>(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            ListNode<T> lastNode = tail;
            lastNode.setNextNode(newNode);

            tail = newNode;
            tail.setPreviousNode(lastNode);
        }

        size += 1;
    }

    public void insertValue(T value, int position) {
        if (position < 0) {
            System.out.println(String.format("Got position %d. Position can not be negative", position));

            return;
        }

        if (position > (size)) {
            System.out.println(String.format(
                    "Can not insert value %s. Position %d is outside list range",
                    value,
                    position
            ));

            return;
        }

        if ((position == size)) {
            addValue(value);

            return;
        }

        ListNode<T> newNode = new ListNode<>(value);

        ListNode<T> nodeAtPosition = getNodeAt(position);

        ListNode<T> previousNode = nodeAtPosition.getPreviousNode();

        nodeAtPosition.setPreviousNode(newNode);

        newNode.setNextNode(nodeAtPosition);

        if (previousNode != null) {
            previousNode.setNextNode(newNode);

            newNode.setPreviousNode(previousNode);
        } else {
            head = newNode;
        }

        size += 1;
    }

    public T getValueAt(int position) {
        ListNode<T> nodeAtPosition = getNodeAt(position);

        return nodeAtPosition.getNodeValue();
    }

    private ListNode<T> getNodeAt(int position) {
        if ((position < 0) || (position > (size - 1))) {
            return null;
        }

        ListNode<T> currentNode = head;
        int currentPosition = 0;

        while (currentPosition != position) {
            currentNode = currentNode.getNextNode();

            currentPosition += 1;
        }

        return (currentNode != null) ? currentNode : null;
    }

    public ListNode getTail() {
        return tail;
    }

    public ListNode getHead() {
        return head;
    }

    public void delete(int position) {
        if (position == 0) {
            head = head.getNextNode();
            head.setPreviousNode(null);

            size -= 1;

            return;
        } else if (position == (size - 1)) {
            tail = tail.getPreviousNode();
            tail.setNextNode(null);

            size -= 1;

            return;
        }

        ListNode<T> nodeToDelete = getNodeAt(position);

        if (nodeToDelete == null) {
            System.out.println(String.format("Can not delete node at position %d. No node at this position", position));

            return;
        }

        ListNode<T> previousNode = nodeToDelete.getPreviousNode();
        ListNode<T> nextNode = nodeToDelete.getNextNode();

        previousNode.setNextNode(nextNode);
        nextNode.setPreviousNode(previousNode);

        nodeToDelete.setNextNode(null);
        nodeToDelete.setPreviousNode(null);

        size -= 1;
    }

    public void clear() {
        head = tail = null;

        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        ListNode currentNode = head;

        do {
            stringBuilder.append(currentNode.getNodeValue());

            if (currentNode != tail) {
                stringBuilder.append(", ");
            }

        } while ((currentNode = currentNode.getNextNode()) != null);

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
