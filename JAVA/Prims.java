import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class PrimMST {
    public static void primMST(ArrayList<ArrayList<Edge>> graph, int V) {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] inMST = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }

        key[0] = 0; // Start with the first vertex

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Edge(0, 0));

        while (!minHeap.isEmpty()) {
            int u = minHeap.poll().to;
            inMST[u] = true;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    minHeap.offer(new Edge(v, key[v]));
                }
            }
        }

        // Print the MST
        for (int i = 1; i < V; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " Weight: " + key[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges and weights to the graph
        graph.get(0).add(new Edge(1, 2));
        graph.get(1).add(new Edge(0, 2));
        graph.get(0).add(new Edge(3, 6));
        graph.get(3).add(new Edge(0, 6));
        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(1, 3));
        graph.get(1).add(new Edge(3, 8));
        graph.get(3).add(new Edge(1, 8));
        graph.get(1).add(new Edge(4, 5));
        graph.get(4).add(new Edge(1, 5));
        graph.get(2).add(new Edge(4, 7));
        graph.get(4).add(new Edge(2, 7));

        primMST(graph, V);
    }
}

// Prim's algorithm is used to find the minimum spanning tree (MST) of a
// connected, undirected graph. Here's a Java implementation of Prim's algorithm
// using a priority queue (Min-Heap)