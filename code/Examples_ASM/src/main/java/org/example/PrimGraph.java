package org.example;

import java.util.*;

class PrimGraph {
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, weight));
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge(source, weight)); // For undirected graph
    }

    public void prim(String start) {
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        List<Edge> mstEdges = new ArrayList<>();

        visited.add(start);
        minHeap.addAll(adjacencyList.get(start));

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            String destination = edge.destination;

            if (!visited.contains(destination)) {
                visited.add(destination);
                mstEdges.add(edge);

                for (Edge e : adjacencyList.get(destination)) {
                    if (!visited.contains(e.destination)) {
                        minHeap.add(e);
                    }
                }
            }
        }

        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge e : mstEdges) {
            System.out.println(e.destination + " - Weight: " + e.weight);
        }
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

class PrimExample {
    public static void main(String[] args) {
        PrimGraph graph = new PrimGraph();
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "B", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "E", 3);

        graph.prim("A");
    }
}

