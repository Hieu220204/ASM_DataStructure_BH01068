package org.example;

import java.util.*;

class Graph {
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, weight));
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge(source, weight)); // For undirected graph
    }

    public void dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<String> visited = new HashSet<>();

        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        minHeap.add(new Edge(start, 0));

        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();
            String currentNode = currentEdge.destination;

            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            for (Edge edge : adjacencyList.get(currentNode)) {
                String adjacentNode = edge.destination;
                int newDist = distances.get(currentNode) + edge.weight;

                if (newDist < distances.get(adjacentNode)) {
                    distances.put(adjacentNode, newDist);
                    minHeap.add(new Edge(adjacentNode, newDist));
                }
            }
        }

        System.out.println("Shortest distances from source: " + distances);
    }

    static class Edge {
        String destination;
        int weight;

        public Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}

class DijkstraExample {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "B", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "E", 3);

        graph.dijkstra("A");
    }
}

