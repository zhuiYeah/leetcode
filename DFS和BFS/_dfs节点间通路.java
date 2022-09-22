package DFS和BFS;

import java.util.*;

//写的磕磕巴巴
public class _dfs节点间通路 {
    Map<Integer, Set<Integer>> next = new HashMap<>();
    boolean[] visited;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        for (int i = 0; i < graph.length; i++) {
            Set<Integer> set = next.getOrDefault(graph[i][0], new HashSet<Integer>());
            set.add(graph[i][1]);
            next.put(graph[i][0], set);
        }
        visited = new boolean[n];
        return dfs(start, target);
    }

    public boolean dfs(int start, int target) {
        if (start == target) {
            return true;
        }
        visited[start] = true;
        Set<Integer> set = next.getOrDefault(start, new HashSet<>());
        for (int next : set) {
            if (!visited[next]) {
                if (dfs(next, target)) {
                    return true;
                }
            }
        }
        visited[start] = false;
        return false;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//用linkedList比用HashSet快了很多
class _dfs节de点间通路 {
    Map<Integer, LinkedList<Integer>> next = new HashMap<>();
    boolean[] visited;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        for (int i = 0; i < graph.length; i++) {
            LinkedList<Integer> list = next.getOrDefault(graph[i][0], new LinkedList<>());
            list.add(graph[i][1]);
            next.put(graph[i][0], list);
        }
        visited = new boolean[n];
        return dfs(start, target);
    }

    public boolean dfs(int start, int target) {
        if (start == target) {
            return true;
        }
        visited[start] = true;
        LinkedList<Integer> list = next.getOrDefault(start, new LinkedList<>());
        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                if (dfs(list.get(i), target)) {
                    return true;
                }
            }
        }
        visited[start] = false;
        return false;
    }
}