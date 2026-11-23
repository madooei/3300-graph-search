package search;

import graph.Graph;
import set.Set;

/** Runs the graph search scenarios against the recursive depth-first search. */
public class DepthFirstRecursiveTest extends GraphSearchTest {

  @Override
  protected Set<Integer> search(Graph<Integer> graph, int start) {
    return DepthFirstRecursive.search(graph, start);
  }
}
