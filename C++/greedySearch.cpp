#include <iostream>
#include <vector>
#include <map>
#include <queue>
#include <algorithm>

struct Node {
    int id;
    int g;
    int h;
    Node* parent;

    Node(int id, int g, int h) : id(id), g(g), h(h), parent(nullptr) {}
};

class Graph {
private:
    std::map<int, std::vector<std::pair<int, int>>> graph;

public:
    void addEdge(int from, int to, int weight) {
        if (graph.find(from) == graph.end()) {
            graph[from] = std::vector<std::pair<int, int>>();
        }
        graph[from].push_back(std::make_pair(to, weight));
    }

    std::vector<std::pair<int, int>> getNeighbors(int node) {
        if (graph.find(node) != graph.end()) {
            return graph[node];
        }
        return std::vector<std::pair<int, int>>();
    }
};

std::vector<int> findShortestPath(Graph& graph, int startNode, int goalNode) {
    std::priority_queue<Node*, std::vector<Node*>, decltype(&compareNodes)> openList(compareNodes);
    std::map<int, int> gValues;
    openList.push(new Node(startNode, 0, heuristic(startNode, goalNode));
    gValues[startNode] = 0;

    while (!openList.empty()) {
        Node* currentNode = openList.top();
        openList.pop();

        if (currentNode->id == goalNode) {
            std::vector<int> path = reconstructPath(currentNode);
            // Clean up allocated memory
            while (!openList.empty()) {
                delete openList.top();
                openList.pop();
            }
            return path;
        }

        for (auto neighborEdge : graph.getNeighbors(currentNode->id)) {
            int neighborNode = neighborEdge.first;
            int edgeWeight = neighborEdge.second;
            int tentativeG = currentNode->g + edgeWeight;

            if (gValues.find(neighborNode) == gValues.end() || tentativeG < gValues[neighborNode]) {
                gValues[neighborNode] = tentativeG;
                Node* neighbor = new Node(neighborNode, tentativeG, heuristic(neighborNode, goalNode));
                neighbor->parent = currentNode;
                openList.push(neighbor);
            }
        }
    }
    return std::vector<int>();
}

std::vector<int> reconstructPath(Node* goalNode) {
    std::vector<int> path;
    Node* current = goalNode;
    while (current != nullptr) {
        path.push_back(current->id);
        current = current->parent;
    }
    std::reverse(path.begin(), path.end());
    return path;
}

int heuristic(int node, int goalNode) {
    return abs(node - goalNode);
}

bool compareNodes(Node* a, Node* b) {
    return (a->g + a->h) > (b->g + b->h);
}

int main() {
    Graph graph;
    graph.addEdge(1, 2, 4);
    graph.addEdge(1, 3, 2);
    graph.addEdge(2, 3, 5);
    graph.addEdge(2, 4, 10);
    graph.addEdge(3, 5, 3);
    graph.addEdge(5, 4, 4);
    graph.addEdge(4, 6, 11);

    std::cout << "Enter the starting node: ";
    int startNode;
    std::cin >> startNode;

    std::cout << "Enter the destination node: ";
    int goalNode;
    std::cin >> goalNode;

    std::vector<int> path = findShortestPath(graph, startNode, goalNode);

    if (!path.empty()) {
        std::cout << "Shortest Path from " << startNode << " to " << goalNode << ": ";
        for (int node : path) {
            std::cout << node << " ";
        }
        std::cout << std::endl;
    } else {
        std::cout << "No path found from " << startNode << " to " << goalNode << std::endl;
    }

    return 0;
}
