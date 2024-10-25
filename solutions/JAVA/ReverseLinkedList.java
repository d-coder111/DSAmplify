public class ReverseLinkedList {
    // Reversal of Linked List in JAVA
    // Alternate approach to recusion
    // Assume three node previous , current and next
    // We can see that somehow we want our head to be at the last node and all linking reversed
    // so we can take 3 pointers previous, current, next
    // Break the link of current with next and connect to previous, mover the
    // pointers one by one ahead and connect the pointers.

    private static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    private static Node reverseLL(Node head) {
        Node currNode = head;
        Node prevNode = null;
        Node nextNode = currNode;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node reversed = reverseLL(head);
        while (reversed != null) {
            System.out.print(reversed.val + "->");
            reversed = reversed.next;
        }
        System.out.print("END");
    }
}
