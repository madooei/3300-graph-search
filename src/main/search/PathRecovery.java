package search;

import graph.Graph;
import list.ArrayList;
import list.List;
import map.HashMap;
import map.Map;
import queue.LinkedQueue;
import queue.Queue;
import set.HashSet;
import set.Set;
import stack.ArrayStack;
import stack.Stack;

/** Recovering a path from a breadth-first search. */
public final class PathRecovery {

  private PathRecovery() {
    // This class should not be instantiated!
  }

  // Returns a map from each vertex reachable from start, other than start, to
  // the vertex it was first reached from. Assumes graph is not null and start
  // is a vertex of graph.
  public static <V> Map<V, V> search(Graph<V> graph, V start) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the path from start to target, read from a predecessor map built
  // by a search from start. Returns an empty list if target was not reached.
  // Assumes predecessor, start, and target are not null.
  public static <V> List<V> pathTo(Map<V, V> predecessor, V start, V target) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns a map from each vertex the search reached, other than start, to
  // the vertex it was first reached from. The search stops when target comes
  // out of the queue. Assumes graph is not null and start and target are
  // vertices of graph.
  public static <V> Map<V, V> search(Graph<V> graph, V start, V target) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
