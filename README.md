# Graph Search

The code for the graph search chapter: depth-first search, written recursively and with an explicit stack, breadth-first search with a queue, recovering a path, and searching for a target. Each search has a JUnit suite, and so does the hash set they use.

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
        PathRecovery.java             # search, search with a target, and pathTo
      graph/
        Graph.java                    # unchanged copy of the Graph ADT
        AdjacencyListGraph.java       # unchanged copy of the graph chapter's implementation
      set/
        Set.java                      # unchanged copy of the course Set ADT
        HashSet.java                  # a hash set with separate chaining, copied from the chaining chapter
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
      demo/                           # one demo per search class
        DepthFirstRecursiveDemo.java
        DepthFirstStackDemo.java
        BreadthFirstDemo.java
        PathRecoveryDemo.java
    test/
      search/
        GraphSearchTest.java          # the abstract search scenarios
        DepthFirstRecursiveTest.java  # runs them against DepthFirstRecursive
        DepthFirstStackTest.java      # runs them against DepthFirstStack
        BreadthFirstTest.java         # runs them against BreadthFirst
        PathRecoveryTest.java
      set/
        SetTest.java                  # unchanged copy of the course Set contract suite
        HashSetTest.java              # runs it against HashSet
  scripts/
    test.sh                           # compile and run the JUnit tests
    run.sh                            # compile and run one demo
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh search.BreadthFirstTest` — compiles everything and runs only that test class.
- `scripts/run.sh demo.BreadthFirstDemo` — compiles everything and runs that one demo. Every class you implement has its own demo.

## What's here

- `search.DepthFirstRecursive`, `search.DepthFirstStack`, and `search.BreadthFirst` — each returns the `Set` of vertices reachable from a start vertex.
- `search.PathRecovery` — `search` runs a breadth-first search and returns the vertex each vertex was reached from; its overload with a target stops when the target comes out of the queue; `pathTo` reads a path back out of either map.
- `set.HashSet` — the visited set: the separate chaining chapter's hash set, copied unchanged. `set.HashSetTest` is copied with it: it runs the course `Set` contract suite against `HashSet`, then checks the buckets by reflection.
- `demo.DepthFirstRecursiveDemo`, `demo.DepthFirstStackDemo`, `demo.BreadthFirstDemo`, and `demo.PathRecoveryDemo` — one demo per search class, each on the chapter's seven-vertex example graph.
