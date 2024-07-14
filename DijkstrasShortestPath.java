import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge {
int destination;
int weight;

Edge(int destination, int weight) {
    this.destination = destination;
    this.weight = weight;
}
}

class DijkstrasShortestPath {
private int numVertices;
private ArrayList<ArrayList<Edge>> graph;
private int[] distance;
private int[] previous;

public DijkstrasShortestPath() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of vertices: ");
    numVertices = scanner.nextInt();
    graph = new ArrayList<>();
    for (int i = 0; i < numVertices; i++) {
        graph.add(new ArrayList<>());
    }

    System.out.print("Enter the number of edges: ");
    int numEdges = scanner.nextInt();
    System.out.println("Enter the edges (source destination weight):");
    for (int i = 0; i < numEdges; i++) {
        int source = scanner.nextInt() - 1; // Adjust vertex numbering
        int destination = scanner.nextInt() - 1; // Adjust vertex numbering
        int weight = scanner.nextInt();
        graph.get(source).add(new Edge(destination, weight));
    }
}

public void findShortestPath(int source) {
    distance = new int[numVertices];
    previous = new int[numVertices];
    for (int i = 0; i < numVertices; i++) {
        distance[i] = Integer.MAX_VALUE;
        previous[i] = -1;
    }
    distance[source] = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distance[a] - distance[b]);
    pq.offer(source);

    while (!pq.isEmpty()) {
        int u = pq.poll();
        for (Edge edge : graph.get(u)) {
            int v = edge.destination;
            int weight = edge.weight;
            if (distance[v] > distance[u] + weight) {
                distance[v] = distance[u] + weight;
                previous[v] = u;
                pq.offer(v);
            }
        }
    }

    System.out.println("Shortest paths from source " + (source + 1) + ":");
    for (int i = 0; i < numVertices; i++) {
        if (i != source) {
            System.out.print("Vertex " + (i + 1) + ": ");
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("No path");
            } else {
                System.out.println("Distance: " + distance[i] + ", Path: " + reconstructPath(i));
            }
        }
    }
}

private String reconstructPath(int destination) {
    StringBuilder path = new StringBuilder();
    int vertex = destination;
    while (previous[vertex] != -1) {
        path.insert(0, (vertex + 1) + " "); // Adjust vertex numbering
        vertex = previous[vertex];
    }
    path.insert(0, (vertex + 1) + " "); // Adjust vertex numbering
    return path.toString();
}
}