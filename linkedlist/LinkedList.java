package linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

// Insert at end
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
// insert at end by Node

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

// insert at start
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

// insert after a specific node
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

// Traversal 
    public int searchPosition(int value) {
        int position = 1;
        Node temp = this.head;
        while (temp != null) {
            if (temp.getData() == value) {
                return position;
            }
            position++;
            temp = temp.next;
        }
        return -1;
    }
// recursive Traversal

    public int rSearchPosition(int value, int position, Node node) {
        if (node == null) {
            return -1;
        }
        if (node.getData() == value) {
            return position;
        }
        position++;
        node = node.next;
        return this.rSearchPosition(value, position, node);
    }

    // method overloading to send default arguments
    public int rSearchPosition(int value) {
        return this.rSearchPosition(value, 1, this.getHead());
    }


    // Delete First element
    public void deleteFirst(){
        this.head = head.next;
    }

// Print all data
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
