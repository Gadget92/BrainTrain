public class ItemLinkedList<integer> {
    integer element;

    public ItemLinkedList getPrev() {
        return prev;
    }

    public void setPrev(ItemLinkedList prev) {
        this.prev = prev;
    }

    public ItemLinkedList getNext() {
        return next;
    }

    public void setNext(ItemLinkedList next) {
        this.next = next;
    }

    ItemLinkedList prev;
    ItemLinkedList next;


    public ItemLinkedList(integer element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "ItemLinkedList{" +
                "element=" + element +
                '}';
    }

}
