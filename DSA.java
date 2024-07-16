
import linkedlist.LinkedList;
import linkedlist.Node;

public class DSA {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        Node node = new Node(2);
        list.append(node);
        list.append(16);
        list.push(15);
        list.append(23);
        list.print();
        System.out.println(" " + list.rSearchPosition(23));
        list.append(58);
        list.insert(node, 55);
        list.deleteFirst();
        list.print();
        System.out.println(" " + list.rSearchPosition(23));
        System.out.println(" " + list.searchPosition(85));
        // System.out.println (list.getTail().data);
    }
}
