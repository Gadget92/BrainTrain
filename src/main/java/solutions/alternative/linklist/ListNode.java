package solutions.alternative.linklist;

public class ListNode<T> {
    private T nodeValue;

    private ListNode<T> previousNode = null;

    private ListNode<T> nextNode = null;

    ListNode(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    public T getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    public ListNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(ListNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    public ListNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return String .valueOf(nodeValue);
    }
}
