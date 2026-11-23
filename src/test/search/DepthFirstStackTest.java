package search;

import graph.Graph;
import set.Set;

/** Runs the graph search scenarios against the depth-first search with an explicit stack. */
public class DepthFirstStackTest extends GraphSearchTest {

  @Override
  protected Set<Integer> search(Graph<Integer> graph, int start) {
    return DepthFirstStack.search(graph, start);
  }
}
