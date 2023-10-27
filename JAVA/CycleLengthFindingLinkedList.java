public class CycleLengthFindingLinkedList {
    // We Have Detected the cycle in Linked List
    // You can check CycleDetectionSinglyLinkedList.java for details 
    // https://github.com/d-coder111/DSAmplify/blob/main/JAVA/CycleDetectionSinglyLinkedList.java
    // Now how to find the Length.

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
        System.out.println(findLength(head));
    }

    private static int findLength(Node head){

        int length =0;
        // In Floyd's method, slow pointer moved by one unit whereas fast pointer moves by 2 units
        // Create a temporary node at slow, traverse it until it pointes back again to fast pointer. Count the iteration to do it will be the length
        // Below is code of cycle 
        Node slow= head;
        Node fast= head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                // Find Length
                Node temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow); // Do while because we want the loop to run at least once
                return length;
            }
        }
        return length;
    }
}
