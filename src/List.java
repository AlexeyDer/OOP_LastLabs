public class List implements InterfaceList {
    Node head, tail;

    public List(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public List(Node head) {
        this.head = head;
    }

    public List() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void print(Node head) {
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data + " ");
        }
        System.out.println();
    }

    @Override
    public void delete(Node t) {
        for (Node p = head; p != null; p = p.next) {
            if (p == t) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                p = null;
            }
        }
    }

    public int Amount(Node head) {
        int result = 0;
        for (Node p = head; p != null; p = p.next) {
            result++;
        }
        return result;
    }

    public boolean MoveElements(Node head, byte a, byte b) {
        int position = 1;
        int pos1 = 0, pos2 = 0;
        Node one = null, two = null;
        Node t = new Node();

        for (Node p = head; p != null; p = p.next) {
            if (one == null && (a == p.data) && (two != p)) {
                one = p;
                if (pos1 == 0)
                    pos1 = position;
                else
                    pos2 = position;
            }
            if ((two == null) && (b == p.data) && (one != p)) {
                two = p;
                if (pos1 == 0)
                    pos1 = position;
                else
                    pos2 = position;
            }
            ++position;
        }
        //	System.out.print(pos1 + " " + pos2);

        if (pos1 == 0 || pos2 == 0)
            return true;


        if (one.next != two) {
            t.next = one.next;
            t.prev = one.prev;

            one.next = two.next;
            one.next.prev = two;
            one.prev.next = two;
            one.prev = two.prev;
            two.prev.next = one;

            two.next = t.next;
            two.prev = t.prev;
        } else {
            one.next = two.next;
            two.next.prev = one;
            two.next = one;
            two.prev = one.prev;
            one.prev = two;
            two.prev.next = two;
        }

        return false;
    }

    public boolean AddOneElement(Node head, byte data, byte k) {

        for (Node p = head; p != null; p = p.next) {
            if (k == p.data) {
                if (p.next != null) {
                    Node tmp = new Node(data);
                    tmp.next = p.next;
                    p.next.prev = tmp;
                    p.next = tmp;
                    tmp.prev = p;
                    return true;
                }
                else {
                    Node temp = new Node(data);
                    temp.prev = tail;
                    tail.next = temp;
                    tail = temp;
                    return true;
                }
            }
        }
        return false;
    }

    public void DeleteDuplicateItems(Node head) {
        for (Node p = head; p.next != null; p = p.next) {
            for (Node q = p.next; q != null; q = q.next) {
                if (p.data == q.data) {
                    if (q.next != null) {
                        Node t = q;
                        t.prev.next = t.next;
                        t.next.prev = t.prev;
                        t = null;
                    }
                    else {
                        Node t = q;
                        t.prev.next =null;
                        t.prev = null;
                        t = null;
                    }
                }
            }
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }



}
