package search;

import graph.Graph;
import queue.LinkedQueue;
import queue.Queue;
import set.HashSet;
import set.Set;

/** Breadth-first search, written with a queue. */
public final class BreadthFirst {

  private BreadthFirst() {
    // This class should not be instantiated!
  }

  // Returns the set of vertices reachable from start, including start.
  // Assumes graph is not null and start is a vertex of graph.
  public static <V> Set<V> search(Graph<V> graph, V start) {
    Set<V> visited = new HashSet<>();
    Queue<V> toProcess = new LinkedQueue<>();

    visited.add(start);
    toProcess.enqueue(start);

    while (!toProcess.isEmpty()) {
      V v = toProcess.front();
      toProcess.dequeue();
      for (V neighbor : graph.neighbors(v)) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          toProcess.enqueue(neighbor);
        }
      }
    }
    return visited;
  }
}
