# Graph Search

The code for the graph search chapter: depth-first search, written recursively and with an explicit stack, breadth-first search with a queue, recovering a path, and counting connected components. Each search has a JUnit suite, and so does the hash set they use.

## Prerequisites

- JDK 17+ (JUnit 6 requires it).
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      search/
        DepthFirstRecursive.java      # depth-first search, recursively
        DepthFirstStack.java          # depth-first search with an explicit stack
        BreadthFirst.java             # breadth-first search with a queue
        PathRecovery.java             # predecessors and pathTo
        Components.java               # countComponents
        Main.java                     # a small demo
      graph/
        Graph.java                    # unchanged copy of the Graph ADT
        AdjacencyListGraph.java       # unchanged copy of the graph chapter's implementation
      set/
        Set.java                      # unchanged copy of the course Set ADT
        HashSet.java                  # a set backed by the course HashMap
      map/
        Map.java                      # unchanged copy of the course Map ADT
        HashMap.java                  # unchanged copy of the course hash table
      stack/
        Stack.java                    # unchanged copy of the course Stack ADT
        ArrayStack.java               # unchanged copy of the course array stack
      queue/
        Queue.java                    # unchanged copy of the course Queue ADT
        LinkedQueue.java              # unchanged copy of the course linked queue
      list/
        List.java                     # unchanged copy of the course List ADT
        ArrayList.java                # unchanged copy of the course array list
    test/
      search/
        GraphSearchTest.java          # the abstract search scenarios
        DepthFirstRecursiveTest.java  # runs them against DepthFirstRecursive
        DepthFirstStackTest.java      # runs them against DepthFirstStack
        BreadthFirstTest.java         # runs them against BreadthFirst
        PathRecoveryTest.java
        ComponentsTest.java
      set/
        SetTest.java                  # unchanged copy of the course Set contract suite
        HashSetTest.java              # runs it against HashSet
  scripts/
    run.sh                            # compile and run the demo
    test.sh                           # compile and run the JUnit tests
```

## How to compile and run

- `scripts/run.sh` — compiles the source and runs `search.Main`.
- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh search.BreadthFirstTest` — compiles everything and runs only that test class.

## What's here

- `search.DepthFirstRecursive`, `search.DepthFirstStack`, and `search.BreadthFirst` — each returns the `Set` of vertices reachable from a start vertex.
- `search.PathRecovery` — `predecessors` runs a breadth-first search and records the vertex each vertex was reached from; `pathTo` reads a path back out of that map.
- `search.Components` — `countComponents` counts the connected components of an undirected graph.
- `search.Main` — runs the searches on the chapter's seven-vertex example graph.
- `set.HashSet` — the visited set. It is new in this repo: a `Set` whose elements are the keys of a course `HashMap`. `set.HashSetTest` runs the course `Set` contract suite against it.
