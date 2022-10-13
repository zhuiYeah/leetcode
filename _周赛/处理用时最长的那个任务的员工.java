package _周赛;

import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

//来自314场周赛
//提交6次错误的简单题 😂
public class 处理用时最长的那个任务的员工 {
    public int hardestWorker(int n, int[][] logs) {
        int max = 0;
        //映射员工号和时长
        var map = new HashMap<Integer, Integer>();
        var start = 0;
        int res = Integer.MAX_VALUE;
        for (int[] log : logs) {
            int id = log[0];
            int end = log[1];
            int time = map.getOrDefault(id, 0);
            int newTime = Math.max(end - start, time);
            map.put(id, newTime);

            if (newTime >= max) {
                if (max == newTime) {
                    if (id < res) res = id;
                } else {
                    res = id;
                }
                max = newTime;
            }
            start = log[1];
        }
        return res;
    }
}
