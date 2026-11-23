package search;

import graph.AdjacencyListGraph;
import graph.Graph;
import list.List;
import map.Map;
import set.Set;

/** A small demo of the graph searches on the chapter's example graph. */
public final class Main {

  private Main() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Graph<Integer> graph = buildExampleGraph();

    Set<Integer> reachable = BreadthFirst.search(graph, 0);
    System.out.println("Reachable from 0: " + reachable.size() + " vertices");

    Map<Integer, Integer> predecessor = PathRecovery.search(graph, 0);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 6);
    String line = "Path 0 -> 6: " + path.get(0);
    for (int i = 1; i < path.size(); i++) {
      line += " -> " + path.get(i);
    }
    System.out.println(line);

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
