package 图;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 找到小镇的法官 {
    public int findJudge(int n, int[][] trust) {
        //先用set记录所有人
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= n; i++) set.add(i);
        // 几号 -》 该号码 信任的 所有人
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int[] x : trust) {
            var beTrust = map.getOrDefault(x[0], new HashSet<Integer>());
            beTrust.add(x[1]);
            map.put(x[0], beTrust);
            set.remove(x[0]);
        }
        //现在set中必须包含唯一一个人，这唯一的不相信任何人的人有可能是小镇法官
        if (set.size() != 1 || map.size() != n - 1) return -1;
        int maybeJudge = -1;
        for (int i : set) maybeJudge = i;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (!entry.getValue().contains(maybeJudge)) return -1;
        }
        return maybeJudge;
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//用一个二维数组记录每个结点的入度和出度，出度为0入度为N-1的就是法官
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] people = new int[N+1][2];
        for(int[] x : trust){
            int out = x[0];
            int in = x[1];
            people[out][0] ++;
            people[in][1] ++;
        }
        for(int i = 1; i <= N; i ++){
            if(people[i][0] == 0 && people[i][1] == N - 1)
                return i;
        }
        return -1;
    }
}