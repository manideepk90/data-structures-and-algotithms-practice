package linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
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
            this.tail = newNode;
        }
        return data;
    }

    public int append(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            this.tail = node;
        }
        return node.getData();
    }

    public int push(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        return data;
    }

    public int push(Node node) {
        node.next = this.head;
        this.head = node;
        return node.getData();
    }

    public int insert(Node prevNode, int data) {
        Node newNode = new Node(data);
        if (prevNode == null) {
            return -1;
        }
        if (prevNode.next == null) {
            prevNode.next = newNode;
            this.tail = newNode;
            return data;
        }

        Node temp = prevNode.next;
        newNode.next = temp;
        prevNode.next = newNode;
        return data;
    }

    public int pop(int data) {
        Node temp = this.getTail();
        // delete temp;
        return -1;
    }

    public int print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(", ");
            }
            temp = temp.next;

        }
        return 0;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }
}
