public class Stack extends List {

    public Stack() {
        super();
    }

    public Stack(Node head) {
        super(head);
    }

    public Stack(Node head, Node tail) {
        super(head, tail);
    }

    public void Insert(Node p, byte data) {
        if (head == null) {
            p = new Node(data);
            head = tail = p;
            head.next = null;
            head.prev = null;
        } else {
            p = new Node(data);
            p.next = head;
            head.prev = p;
            head = p;
        }
    }

}
