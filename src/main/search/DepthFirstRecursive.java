package search;

import graph.Graph;
import set.HashSet;
import set.Set;

/** Depth-first search, written recursively. */
public final class DepthFirstRecursive {

  private DepthFirstRecursive() {
    // This class should not be instantiated!
  }

  // Returns the set of vertices reachable from start, including start.
  // Assumes graph is not null and start is a vertex of graph.
  public static <V> Set<V> search(Graph<V> graph, V start) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Marks v as visited, then searches from each neighbor of v not yet visited.
  private static <V> void search(Graph<V> graph, V v, Set<V> visited) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
