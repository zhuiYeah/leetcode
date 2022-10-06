package 图;

import java.util.ArrayList;
import java.util.List;

//找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。

//记录所有入度为0的点即可
public class 可以到达所有点的最少点数目 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //记录每个点的入度
        int[] in = new int[n];
        for (List<Integer> list : edges) in[list.get(1)]++;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) res.add(i);
        }
        return res;
    }
}
