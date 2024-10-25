/**
 * Java program to reverse alternate levels of a perfect binary tree.
 */

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class PerfectBinaryTree {
    Node root;

    /**
     * Function to reverse alternate levels of a perfect binary tree.
     *
     * @param node  The root of the binary tree.
     * @param level The current level (0 for root) of the tree.
     */
    public void reverseAlternateLevels(Node node, int level) {
        if (node == null) {
            return;
        }

        // If the current level is even, reverse the nodes
        if (level % 2 == 0) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        // Recursively reverse alternate levels for left and right subtrees
        reverseAlternateLevels(node.left, level + 1);
        reverseAlternateLevels(node.right, level + 1);
    }

    /**
     * Function to print the tree in-order.
     *
     * @param node The root of the binary tree.
     */
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        PerfectBinaryTree tree = new PerfectBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Original tree (in-order):");
        tree.inOrder(tree.root);
        System.out.println();

        tree.reverseAlternateLevels(tree.root, 0);

        System.out.println("Tree after reversing alternate levels (in-order):");
        tree.inOrder(tree.root);
    }
}
