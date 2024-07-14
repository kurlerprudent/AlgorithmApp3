import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Edge {
int source, destination, weight;

Edge(int source, int destination, int weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
}
}

class KruskalsMST {
private int numVertices;
private ArrayList<Edge> edges;
private int[] parent;

public KruskalsMST() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of vertices: ");
    numVertices = scanner.nextInt();
    parent = new int[numVertices];
    for (int i = 0; i < numVertices; i++) {
        parent[i] = i;
    }

    System.out.print("Enter the number of edges: ");
    int numEdges = scanner.nextInt();
    edges = new ArrayList<>();
    System.out.println("Enter the edges (source destination weight):");
    for (int i = 0; i < numEdges; i++) {
        int source = scanner.nextInt();
        int destination = scanner.nextInt();
        int weight = scanner.nextInt();
        edges.add(new Edge(source, destination, weight));
    }
}

public void findMST() {
    Collections.sort(edges, Comparator.comparingInt(e -> e.weight));
    ArrayList<Edge> mst = new ArrayList<>();

    for (Edge edge : edges) {
        if (find(edge.source) != find(edge.destination)) {
            mst.add(edge);
            union(edge.source, edge.destination);
        }
    }

    System.out.println("The Minimum Spanning Tree is:");
    for (Edge edge : mst) {
        System.out.println("(" + edge.source + ", " + edge.destination + ") - Weight: " + edge.weight);
    }
}

private int find(int x) {
    if (parent[x] != x) {
        parent[x] = find(parent[x]);
    }
    return parent[x];
}

private void union(int x, int y) {
    int xRoot = find(x);
    int yRoot = find(y);
    parent[xRoot] = yRoot;
}
}