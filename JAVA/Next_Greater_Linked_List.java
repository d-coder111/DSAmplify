import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Next_Greater_Linked_List {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(1);
        ListNode dummy = head;
        System.out.println(Arrays.toString(nextLargerNodes(dummy)));
    }

    public static int[] nextLargerNodes(ListNode head) {
        ListNode dummy = head;

        List<Integer> nodes = new ArrayList<>();
        while (dummy != null) {
            nodes.add(dummy.val);
            dummy = dummy.next;
        }
        int[] node = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            node[i] = nodes.get(i);
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[node.length];
        for (int i = 0; i < node.length; i++) {
            while (!stack.isEmpty() && node[stack.peek()] < node[i]) {
                ans[stack.pop()] = node[i];
            }
            stack.push(i);
        }
        return ans;
    }
}
