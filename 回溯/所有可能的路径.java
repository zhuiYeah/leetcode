package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 所有可能的路径 {
     int[][] graphX;
     List<List<Integer>> result = new ArrayList<>();
     int n;

    public  List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        graphX = graph;
        n = graph.length;
        var path = new ArrayList<Integer>();
        path.add(0);
        backtracking(path, 0);
        return result;
    }

    public  void backtracking(List<Integer> path, int curNode) {

        if (curNode == n-1){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graphX[curNode].length; i++) {
            path.add(graphX[curNode][i]);
            backtracking(path, graphX[curNode][i]);
            path.remove(path.size()-1);
        }
    }

}
