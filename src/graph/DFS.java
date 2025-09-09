package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {

  private static final List<Integer> path = new ArrayList<>();
  private static final Set<Integer> visited = new HashSet<>();
  private static final Map<Integer, List<Integer>> graph = new HashMap<>();

  public static void main(String[] args) {
    graph.put(1, List.of(2, 5));
    graph.put(2, List.of(1, 3, 5));
    graph.put(3, List.of(2, 4));
    graph.put(4, List.of(3, 5, 6));
    graph.put(5, List.of(1, 2, 4));
    graph.put(6, List.of(4));

    dfs(1, 6);
  }

  private static void dfs(int u, int dest) {
    if (u == dest) {
      path.add(dest);
      System.out.println(path);
      path.removeLast();
      return;
    }

    path.add(u);
    visited.add(u);
    System.out.println("Visiting: " + u + " | Path so far: " + path);

    for (int v : graph.get(u)) {
      if (!visited.contains(v)) {
        dfs(v, dest);
      }
    }


    path.removeLast();
    visited.remove(u);
    System.out.println("Visiting: " + u + " | Path so far: " + path);
  }
}
