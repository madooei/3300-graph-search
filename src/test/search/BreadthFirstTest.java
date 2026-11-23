package search;

import graph.Graph;
import set.Set;

/** Runs the graph search scenarios against the breadth-first search. */
public class BreadthFirstTest extends GraphSearchTest {

  @Override
  protected Set<Integer> search(Graph<Integer> graph, int start) {
    return BreadthFirst.search(graph, start);
  }
}
