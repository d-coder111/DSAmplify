public class CycleStartNodeSearch {

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
        System.out.println(findNode(head).val);
    }

    private static Node findNode(Node head) {
        // Assume the distance covered or traversed by slow and fast pointers be sDist
        // and fDist.
        // Clearly we know from Floyd's Method that distance convered by fast pointer
        // will be twice of slow
        // 2 x sDist = fDist - (formula 1)
        // Figure will be:
        // Ho ------Co-------Mo
        // ⬆︎________⬆︎
        // cycle

        // Also asume the distance between head and cycle-start node be d1 (Ho -> Co)
        // Distance of node where slow and fast meet to cycle-start be d2(Co -> Mo) in
        // forward and d3(Mo -> Co)
        // sDist = d1+d2
        // fDist = d1+d2+d3+d4
        // from formula 1:
        // 2(d1+d2) = d1+d2+d3+d2
        // Solving gives: d1 = d3
        // Means traverse head and slow and they will meet at the cycle start point

        Node dummyHead = head;
        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                Node temp = slow;
                if (dummyHead == temp) {
                    return temp;
                } else {
                    do {
                        temp = temp.next;
                        dummyHead = dummyHead.next;
                    } while (temp != dummyHead);

                    return dummyHead;
                }
            }
        }
        return null;
    }
}
