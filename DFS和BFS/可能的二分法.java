package DFS和BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//超时
// 31 / 70
public class 可能的二分法 {
    //A集合中的元素绝对不能和setA中包含的元素放在一起
    Set<Integer> setA = new HashSet<Integer>();
    Set<Integer> setB = new HashSet<Integer>();
    int[][] dislikes;
    //已经分配好的元素
    Set<Integer> used = new HashSet<Integer>();
    int N;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        this.dislikes = dislikes;
        N = dislikes.length;
        return dfs(0);
    }

    public boolean dfs(int curIndex) {
        if (curIndex == N) return true;
        int a = dislikes[curIndex][0], b = dislikes[curIndex][1];
        if (used.contains(a) && used.contains(b)) {
            if (setA.contains(a) && setA.contains(b) || setB.contains(a) && setB.contains(b)) {
                return false;
            } else {
                if (dfs(curIndex + 1)) return true;
            }
        } else if (used.contains(a) && !used.contains(b)) {
            //现在元素b需要往集合A或集合B中防止
            //b绝对不能和a放在一起
            if (!setA.contains(a)) {
                used.add(b);
                setA.add(b);
                if (dfs(curIndex + 1)) return true;
                used.remove(b);
                setA.remove(b);
            }
            if (!setB.contains(a)) {
                used.add(b);
                setB.add(b);
                if (dfs(curIndex + 1)) return true;
                used.remove(b);
                setB.remove(b);
            }
        } else if (used.contains(b) && !used.contains(a)) {
            if (!setA.contains(b)) {
                used.add(a);
                setA.add(a);
                if (dfs(curIndex + 1)) return true;
                used.remove(a);
                setA.remove(a);
            }
            if (!setB.contains(a)) {
                used.add(a);
                setB.add(a);
                if (dfs(curIndex + 1)) return true;
                used.remove(a);
                setB.remove(a);
            }
        } else if (!used.contains(a) && !used.contains(b)) {
            if (!setA.contains(b) && !setB.contains(a)) {
                used.add(a);
                used.add(b);
                setA.add(a);
                setB.add(b);
                if (dfs(curIndex + 1)) return true;
                used.remove(b);
                used.remove(a);
                setA.remove(a);
                setB.remove(b);
            }
            if (!setA.contains(a) && !setB.contains(b)) {
                used.add(a);
                used.add(b);
                setA.add(b);
                setB.add(a);
                if (dfs(curIndex + 1)) return true;
                used.remove(b);
                used.remove(a);
                setA.remove(b);
                setB.remove(a);
            }
        }
        return false;
    }
}


////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
//我们用两种颜色对图进行染色，如果可以完成染色，那么就说明可以将所有人分进两组。
//
//        具体的染色方法如下：
//
//        初始化所有人的颜色为 0，表示还没有染色。
//        遍历所有人，如果当前人没有染色，那么就用颜色 111 对其进行染色，然后将其所有不喜欢的人用颜色 222 进行染色。如果染色过程中出现了冲突，那么就说明无法将所有人分进两组，返回 false。
//        如果所有人都染色成功，那么就说明可以将所有人分进两组，返回 true。

class Solutionug {
    //存放1～n所有元素 以及他们的 对立元素
    private List<Integer>[] g;
    //记录 1～n的染色情况
    private int[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        g = new List[n + 1];
        color = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (var e : dislikes) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (int i = 1; i <= n; ++i) {
            //如果未被染色，就将它染成颜色1，一系列连锁染色能成功吗
            if (color[i] == 0) {
                if (!dfs(i, 1)) return false;
            }
        }
        return true;
    }

    //当前的元素是i，它还未被染色，将它染成c颜色
    private boolean dfs(int i, int c) {
        this.color[i] = c;
        //获得当前点i的所有对立点j，
        for (int j : g[i]) {
            //如果对立点j已被染色 且与当前点的c颜色相同，那么染色不能成功
            if (this.color[j] == c) {
                return false;
            }
            //如果对立点未被染色，将其染色成3-c能成功吗
            if (this.color[j] == 0 && !dfs(j, 3 - c)) {
                return false;
            }
        }
        //染色成功
        return true;
    }
}

