package linked_list;

public class LinkedList {

    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public int append(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return data;
    }

    public int push(int data){
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        return 0;
    }

    public int delete(int data){
        

        return -1;
    }

    public int print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.getData());
            if (temp.next != null) {
                System.out.print(", ");
            }
            temp = temp.next;

        }
        return 0;
    }
}
