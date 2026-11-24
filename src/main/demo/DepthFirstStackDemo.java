package demo;

import graph.AdjacencyListGraph;
import graph.Graph;
import search.DepthFirstStack;
import set.Set;

/** A demo of DepthFirstStack on the chapter's seven-vertex graph. */
public final class DepthFirstStackDemo {

  private DepthFirstStackDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Graph<Integer> graph = buildExampleGraph();
    System.out.println("edges: 0-1, 0-2, 0-3, 1-4, 3-5, 5-6, 4-6");

    // Every vertex is reachable from 0. Expect all seven vertices, 0 through 6.
    Set<Integer> reachable = DepthFirstStack.search(graph, 0);
    String line = "reachable from 0:";
    for (int vertex : reachable) {
      line += " " + vertex;
    }
    System.out.println(line);
    System.out.println("count: " + reachable.size());
  }

  // The chapter's example: seven vertices, 0 through 6, all reachable from 0.
  private static Graph<Integer> buildExampleGraph() {
    Graph<Integer> graph = new AdjacencyListGraph<>();
    for (int vertex = 0; vertex <= 6; vertex++) {
      graph.addVertex(vertex);
    }
    addUndirected(graph, 0, 1);
    addUndirected(graph, 0, 2);
    addUndirected(graph, 0, 3);
    addUndirected(graph, 1, 4);
    addUndirected(graph, 3, 5);
    addUndirected(graph, 5, 6);
    addUndirected(graph, 4, 6);
    return graph;
  }

  // Adds an undirected edge as a directed edge in each direction.
  private static void addUndirected(Graph<Integer> graph, int first, int second) {
    graph.addEdge(first, second);
    graph.addEdge(second, first);
  }
}
