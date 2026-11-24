package demo;

import graph.AdjacencyListGraph;
import graph.Graph;
import list.List;
import map.Map;
import search.PathRecovery;

/** A demo of PathRecovery on the chapter's seven-vertex graph. */
public final class PathRecoveryDemo {

  private PathRecoveryDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Graph<Integer> graph = buildExampleGraph();
    System.out.println("edges: 0-1, 0-2, 0-3, 1-4, 3-5, 5-6, 4-6");

    // Expect the predecessors 1 <- 0, 2 <- 0, 3 <- 0, 4 <- 1, 5 <- 3, and 6 <- 4.
    Map<Integer, Integer> predecessor = PathRecovery.search(graph, 0);
    System.out.println("predecessors from a search from 0:");
    for (int vertex = 1; vertex <= 6; vertex++) {
      System.out.println("  " + vertex + " <- " + predecessor.get(vertex));
    }

    // Follow the predecessors back from 6. Expect 0 -> 1 -> 4 -> 6.
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 6);
    System.out.println("path 0 to 6: " + format(path));

    // The search for target 4 stops when 4 comes out of the queue. Expect 0 -> 1 -> 4.
    Map<Integer, Integer> toTarget = PathRecovery.search(graph, 0, 4);
    List<Integer> shortPath = PathRecovery.pathTo(toTarget, 0, 4);
    System.out.println("path 0 to 4, searching for 4: " + format(shortPath));

    // That search never reached 6, so expect false.
    System.out.println("6 reached: " + toTarget.containsKey(6));
  }

  // Returns the vertices of path joined by arrows.
  private static String format(List<Integer> path) {
    String line = "" + path.get(0);
    for (int i = 1; i < path.size(); i++) {
      line += " -> " + path.get(i);
    }
    return line;
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
