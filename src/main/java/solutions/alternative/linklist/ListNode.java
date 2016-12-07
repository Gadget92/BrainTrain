package solutions.alternative.linklist;

/**
 * Created by zapolsky on 07.12.2016.
 */
public class ListNode {
    private int nodeValue;

    private ListNode previousNode = null;

    private ListNode nextNode = null;

    ListNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public ListNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(ListNode previousNode) {
        this.previousNode = previousNode;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}
