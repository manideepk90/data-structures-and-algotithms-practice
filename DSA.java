
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
        System.out.println("");
        // list.append(58);
        // // list.insert(node, 55);
        // // list.deleteFirst();
        // list.deleteLast();        list.deleteLast();
        // list.deleteLast();
        list.insert(5,3);
        // list.delete(1);
        list.print();
   
     
    }
}
