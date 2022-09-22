package DFS和BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class bfs跳跃游戏III {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        boolean[] seen = new boolean[n];
        seen[start] = true; //新开辟数组标记访问
        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            if (arr[curIndex] == 0) {
                return true;
            }
            int x = curIndex - arr[curIndex];
            if (x >= 0 && !seen[x]) {
                seen[x] = true;
                queue.add(x);
            }
            int y = curIndex + arr[curIndex];
            if (y < n && !seen[y]) {
                seen[y] = true;
                queue.add(y);
            }
        }
        return false;
    }
}

//两种标记已访问的方法耗时相同
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution2 {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            if (arr[curIndex] == 0) {
                return true;
            }
            int x = curIndex - arr[curIndex];
            if (x >= 0 && arr[x] != -1) {
                queue.add(x);
            }
            int y = curIndex + arr[curIndex];
            if (y < n && arr[y] != -1) {
                queue.add(y);
            }
            arr[curIndex] = -1; //对原数组操作标记访问
        }
        return false;
    }
}
