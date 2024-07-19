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

    public void insert(int position, int data) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }
        int currPosition = 1;
        Node curr = this.head;
        while (currPosition != position - 1 && curr != null) {
            currPosition++;
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void sInsert(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        if (this.head.data > data) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }
        Node curr = this.head;
        while (curr.next != null && data > curr.next.data) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void insert(int data) {
        this.insert(1, data);
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
    public void deleteFirst() {
        this.head = head.next;
    }

    public void deleteLast() {
        Node curr = this.head;
        if (curr == null) {
            return;
        }
        if (curr.next == null) {
            this.head = null;
        }
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    public void delete(int position) {
        if (this.head == null) {
            return;
        }
        if (position == 1 && this.head.next != null) {
            this.head = this.head.next;
            return;
        }
        Node curr = this.head;
        int currPosition = 1;
        while (curr.next != null && currPosition != position - 1) {
            currPosition++;
            curr = curr.next;
        }
        if (curr.next == null) {
            // throw new IndexOutOfBoundsException("Position out of the limit");
            return;
        }
        curr.next = curr.next.next;
    }

    public boolean isSorted() {
        Node curr = this.head;
        while (curr != null && curr.next != null && curr.next.next != null) {
            if (curr.data > curr.next.data && curr.next.data < curr.next.next.data) {
                return false;
            }
            if (curr.data < curr.next.data && curr.next.data > curr.next.next.data) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
    // Naive Solution
    // public void reverse() {
    //     if (this.head == null) {
    //         return;
    //     }
    //     ArrayList<Integer> arrayList = new ArrayList<Integer>();
    //     Node curr = this.head;
    //     while (curr != null) {
    //         arrayList.add(curr.data);
    //         curr = curr.next;
    //     }
    //     for (curr = this.head; curr != null; curr = curr.next) {
    //         curr.data = arrayList.remove(arrayList.size() - 1);
    //     }
    // }

    // public void reverse(Node node) {
    //         return null;
    //        }
    // } 
    public void removeDuplicatesFromSortedL() {
        Node curr = this.head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public void reverse() {
        Node prev = null;
        Node curr = this.head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // reverse(this.head);
        this.head = prev;
    }

    // Naive Solution
    // public int middle() {
    //     if (this.head == null) {
    //         return -1;
    //     }
    //     int count = 0;
    //     for (Node curr = this.head; curr != null; curr = curr.next) {
    //         count++;
    //     }
    //     Node curr = this.head;
    //     for (int i = 0; i < count / 2; i++) {
    //         curr = curr.next;
    //     }
    //     return curr.data;
    // }
    public int middle() {
        if (this.head == null) {
            return -1;
        }
        Node first = this.head, second = this.head;
        while (first != null && first.next != null) {
            second = second.next;
            first = first.next.next;
        }
        return second.data;
    }
    // Naive Solution
    // find NthNodefromtheEnd
    // public int findNthFromTheEnd(int n) {
    //     int len = 0;
    //     for (Node curr = this.head; curr != null; curr = curr.next) {
    //         len++;
    //     }
    //     if (n > len) {
    //         return -1;
    //     }
    //     Node curr = this.head;
    //     for (int i = 1; i < len - n + 1; i++) {
    //         curr = curr.next;
    //     }
    //     return curr.data;
    // }

    public int findNthFromTheEnd(int n) {
        Node first = this.head;
        for (int i = 1; i < n && first != null; i++) {
            first = first.next;
        }
        if (first == null) {
            return -1;
        }
        Node second = this.head;
        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        return second.data;
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
