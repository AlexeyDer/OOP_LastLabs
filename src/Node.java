public class Node {
    byte data;

    public Node(byte data) {
        this.data = data;
    }

    public Node() {
        this.data = 0;
    }

    public Node next;
    public Node prev;
}
