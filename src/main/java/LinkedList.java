import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    List<ItemLinkedList> list;

//    public LinkedList(List<ItemLinkedList> list) {
//        if (list != (null)) {
//            this.list = list;
//        }else {
//            list = new ArrayList<>();
//            this.list = list;
//        }
//    }


    public LinkedList() {
    }

    public boolean addItem(int value){
        ItemLinkedList item = new ItemLinkedList(value);

        return true;
    }


}
