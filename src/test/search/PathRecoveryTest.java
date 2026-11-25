package search;

import graph.AdjacencyListGraph;
import graph.Graph;
import list.List;
import map.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests for recovering a path from a breadth-first search. */
public class PathRecoveryTest {

  @Test
  public void searchHasNoEntryForTheStart() {
    Map<Integer, Integer> predecessor = PathRecovery.search(diamond(), 0);
    assertFalse(predecessor.containsKey(0));
  }

  @Test
  public void searchRecordsTheVertexANeighborWasReachedFrom() {
    Map<Integer, Integer> predecessor = PathRecovery.search(diamond(), 0);
    assertEquals(0, predecessor.get(1));
  }

  @Test
  public void searchHasAnEntryForEveryOtherReachableVertex() {
    Map<Integer, Integer> predecessor = PathRecovery.search(diamond(), 0);
    assertEquals(3, predecessor.size());
  }

  @Test
  public void searchHasNoEntryForAnUnreachableVertex() {
    Map<Integer, Integer> predecessor = PathRecovery.search(lineWithLoneVertex(), 0);
    assertFalse(predecessor.containsKey(4));
  }

  @Test
  public void pathToTheStartIsJustTheStart() {
    Map<Integer, Integer> predecessor = PathRecovery.search(diamond(), 0);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 0);
    assertEquals(1, path.size());
  }

  @Test
  public void pathToANeighborHasTwoVertices() {
    Map<Integer, Integer> predecessor = PathRecovery.search(diamond(), 0);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 1);
    assertEquals(2, path.size());
  }

  @Test
  public void pathStartsAtTheStart() {
    Map<Integer, Integer> predecessor = PathRecovery.search(lineWithLoneVertex(), 0);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 3);
    assertEquals(0, path.get(0));
  }

  @Test
  public void pathEndsAtTheTarget() {
    Map<Integer, Integer> predecessor = PathRecovery.search(lineWithLoneVertex(), 0);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 3);
    assertEquals(3, path.get(3));
  }

  @Test
  public void pathListsTheVerticesBetweenInOrder() {
    Map<Integer, Integer> predecessor = PathRecovery.search(lineWithLoneVertex(), 0);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 3);
    assertEquals(1, path.get(1));
  }

  @Test
  public void firstStepOfAPathIsAnEdge() {
    Graph<Integer> graph = diamond();
    Map<Integer, Integer> predecessor = PathRecovery.search(graph, 0);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 3);
    assertTrue(graph.containsEdge(path.get(0), path.get(1)));
  }

  @Test
  public void lastStepOfAPathIsAnEdge() {
    Graph<Integer> graph = diamond();
    Map<Integer, Integer> predecessor = PathRecovery.search(graph, 0);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 3);
    assertTrue(graph.containsEdge(path.get(1), path.get(2)));
  }

  @Test
  public void pathToAnUnreachableVertexIsEmpty() {
    Map<Integer, Integer> predecessor = PathRecovery.search(lineWithLoneVertex(), 0);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 4);
    assertEquals(0, path.size());
  }

  @Test
  public void searchForTheStartRecordsNoPredecessors() {
    Map<Integer, Integer> predecessor = PathRecovery.search(diamond(), 0, 0);
    assertEquals(0, predecessor.size());
  }

  @Test
  public void searchForATargetRecordsTheVertexTheTargetWasReachedFrom() {
    Map<Integer, Integer> predecessor = PathRecovery.search(lineWithLoneVertex(), 0, 3);
    assertEquals(2, predecessor.get(3));
  }

  @Test
  public void searchForATargetGivesThePathToTheTarget() {
    Map<Integer, Integer> predecessor = PathRecovery.search(lineWithLoneVertex(), 0, 3);
    List<Integer> path = PathRecovery.pathTo(predecessor, 0, 3);
    assertEquals(1, path.get(1));
  }

  @Test
  public void searchForAnUnreachableTargetHasNoEntryForTheTarget() {
    Map<Integer, Integer> predecessor = PathRecovery.search(lineWithLoneVertex(), 0, 4);
    assertFalse(predecessor.containsKey(4));
  }

  @Test
  public void searchForAnUnreachableTargetRecordsEveryOtherReachableVertex() {
    Map<Integer, Integer> predecessor = PathRecovery.search(lineWithLoneVertex(), 0, 4);
    assertEquals(3, predecessor.size());
  }

  @Test
  public void searchForATargetStopsWhenTheTargetComesOut() {
    // In the line 0 -> 1 -> 2 -> 3, a search for 1 processes 0 and then 1.
    // It must stop there, so it asks only 0 for its neighbors.
    CountingGraph graph = new CountingGraph();
    for (int vertex = 0; vertex < 4; vertex++) {
      graph.addVertex(vertex);
    }
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    PathRecovery.search(graph, 0, 1);
    assertEquals(1, graph.neighborCalls);
  }

  // The directed diamond 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3.
  private Graph<Integer> diamond() {
    Graph<Integer> graph = vertices(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);
    return graph;
  }

  // The directed line 0 -> 1 -> 2 -> 3, and the vertex 4 with no edges.
  private Graph<Integer> lineWithLoneVertex() {
    Graph<Integer> graph = vertices(5);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    return graph;
  }

  // A graph with the vertices 0 through count - 1 and no edges.
  private Graph<Integer> vertices(int count) {
    Graph<Integer> graph = new AdjacencyListGraph<>();
    for (int vertex = 0; vertex < count; vertex++) {
      graph.addVertex(vertex);
    }
    return graph;
  }

  // An adjacency-list graph that counts its calls to neighbors.
  private static class CountingGraph extends AdjacencyListGraph<Integer> {
    private int neighborCalls;

    @Override
    public Iterable<Integer> neighbors(Integer vertex) {
      neighborCalls++;
      return super.neighbors(vertex);
    }
  }
}
