package 图;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//bfs
public class 钥匙和房间 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        var seen = new HashSet<Integer>();
        var queue = new ArrayDeque<Integer>();
        queue.add(0);
        seen.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (var room : rooms.get(cur)) {
                if (!seen.contains(room)) {
                    seen.add(room);
                    queue.add(room);
                }
            }
        }
        return seen.size() == n;
    }
}
