public class Queue extends List {

    public Queue() {
        super();
    }

    public Queue(Node head) {
        super(head);
    }

    public Queue(Node head, Node tail) {
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
            p.prev = tail;
            tail.next = p;
            tail = p;
            tail.next = null;
        }
    }

}
