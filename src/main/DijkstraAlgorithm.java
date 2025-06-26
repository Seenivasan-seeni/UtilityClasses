package main;
import java.util.*;

class DijkstraAlgorithm {

    // Edge class to represent a connection to a neighbor
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Node class for PriorityQueue (compare by distance)
    static class Node implements Comparable<Node> {
        int vertex, distance;
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int source) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Print final shortest distances
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from A to " + (char)(i + 'A') + " is " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices: A, B, C, D, E
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(new Edge(1, 4)); // A -> B (4)
        graph.get(0).add(new Edge(2, -2)); // A -> C (2)
        graph.get(1).add(new Edge(2, 5)); // B -> C (5)
        graph.get(1).add(new Edge(3, 10)); // B -> D (10)
        graph.get(2).add(new Edge(4, 3)); // C -> E (3)
        graph.get(4).add(new Edge(3, 4)); // E -> D (4)
        graph.get(3).add(new Edge(4, 1)); // D -> E (1)

        dijkstra(graph, 0); // Starting from A (vertex 0)
    }
}
