import java.util.LinkedList;

public class CycleDetectionSinglyLinkedList {

    //Initialzing Node
    private static class Node {
    int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        // Create a linking to cycle point
        Node dummy = head;
        Node cycle = dummy.next;
        head.next.next.next.next = cycle;
        System.out.println(detectCycle(dummy));
    }

    private static boolean detectCycle(Node head) {
        // Intilizing slow and Fast Pointer
        Node slow= head;
        Node fast= head;

        // Checking if the cycle exists
        // If cycle is not present in the LinkedList fast pointer will point to null else Slow and Fast pointer will meet at a point in the cycel
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

}