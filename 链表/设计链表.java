package 链表;

import java.util.ArrayList;
import java.util.List;

public class 设计链表 {
    class MyLinkedList {
        List<Integer> list;

        public MyLinkedList() {
            this.list = new ArrayList<Integer>();
        }

        public int get(int index) {
            if (index < 0 || index >= list.size()) return -1;
            return list.get(index);
        }

        public void addAtHead(int val) {
            list.add(0, val);
        }

        public void addAtTail(int val) {
            list.add(val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index >= list.size()) return;
            list.add(index, val);
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= list.size()) return;
            list.remove(index);
        }
    }
}
