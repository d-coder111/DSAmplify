#include <iostream>
#include <vector>
#include <queue>
#include <limits>

// Define a structure to represent an edge with its weight
struct Edge {
    int to;
    int weight;
    Edge(int t, int w) : to(t), weight(w) {}
};

// Define a comparison operator for the priority queue
struct CompareEdge {
    bool operator()(const Edge& a, const Edge& b) {
        return a.weight > b.weight;
    }
};

// Function to find the shortest path from a source vertex to all other vertices using Dijkstra's algorithm
void dijkstra(std::vector<std::vector<Edge>>& graph, int source, std::vector<int>& distance) {
    int n = graph.size(); // Number of vertices
    distance.assign(n, std::numeric_limits<int>::max()); // Initialize distances to infinity
    distance[source] = 0; // Distance to the source vertex is 0

    std::priority_queue<Edge, std::vector<Edge>, CompareEdge> pq;
    pq.push(Edge(source, 0));

    while (!pq.empty()) {
        int u = pq.top().to;
        int dist_u = pq.top().weight;
        pq.pop();

        if (dist_u != distance[u]) {
            // Skip outdated entries in the priority queue
            continue;
        }

        for (const Edge& edge : graph[u]) {
            int v = edge.to;
            int weight_uv = edge.weight;

            if (distance[u] + weight_uv < distance[v]) {
                distance[v] = distance[u] + weight_uv;
                pq.push(Edge(v, distance[v]));
            }
        }
    }
}

int main() {
    int n = 6; // Number of vertices
    int source = 0; // Source vertex

    std::vector<std::vector<Edge>> graph(n);

    // Add edges to the graph (vertex, weight)
    graph[0].emplace_back(1, 2);
    graph[0].emplace_back(2, 4);
    graph[1].emplace_back(2, 1);
    graph[1].emplace_back(3, 7);
    graph[2].emplace_back(4, 3);
    graph[3].emplace_back(5, 1);
    graph[4].emplace_back(5, 5);

    std::vector<int> distance(n);

    dijkstra(graph, source, distance);

    std::cout << "Shortest distances from vertex " << source << " to all other vertices:" << std::endl;
    for (int i = 0; i < n; i++) {
        std::cout << "Vertex " << i << ": " << distance[i] << std::endl;
    }

    return 0;
}
