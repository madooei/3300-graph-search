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
    Set<V> visited = new HashSet<>();
    Map<V, V> predecessor = new HashMap<>();
    Queue<V> toProcess = new LinkedQueue<>();

    visited.add(start);
    toProcess.enqueue(start);

    while (!toProcess.isEmpty()) {
      V vertex = toProcess.front();
      toProcess.dequeue();
      for (V neighbor : graph.neighbors(vertex)) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          predecessor.put(neighbor, vertex);  // reached neighbor from vertex
          toProcess.enqueue(neighbor);
        }
      }
    }
    return predecessor;
  }

  // Returns the path from start to target, read from a predecessor map built
  // by a search from start. Returns an empty list if target was not reached.
  // Assumes predecessor, start, and target are not null.
  public static <V> List<V> pathTo(Map<V, V> predecessor, V start, V target) {
    List<V> path = new ArrayList<>();
    if (!target.equals(start) && !predecessor.containsKey(target)) {
      return path;  // target unreachable: no path
    }

    Stack<V> stack = new ArrayStack<>();
    V step = target;
    stack.push(step);
    while (!step.equals(start)) {
      step = predecessor.get(step);
      stack.push(step);
    }

    while (!stack.isEmpty()) {
      path.add(stack.top());
      stack.pop();
    }
    return path;
  }

  // Returns a map from each vertex the search reached, other than start, to
  // the vertex it was first reached from. The search stops when target comes
  // out of the queue. Assumes graph is not null and start and target are
  // vertices of graph.
  public static <V> Map<V, V> search(Graph<V> graph, V start, V target) {
    Set<V> visited = new HashSet<>();
    Map<V, V> predecessor = new HashMap<>();
    Queue<V> toProcess = new LinkedQueue<>();

    visited.add(start);
    toProcess.enqueue(start);

    while (!toProcess.isEmpty()) {
      V vertex = toProcess.front();
      toProcess.dequeue();
      if (vertex.equals(target)) {
        break;  // the target came out, so stop the search
      }
      for (V neighbor : graph.neighbors(vertex)) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          predecessor.put(neighbor, vertex);
          toProcess.enqueue(neighbor);
        }
      }
    }
    return predecessor;
  }
}
