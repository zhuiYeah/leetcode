package 记忆化搜索;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

//来自318场周赛，非常难

//灵神思路，定义f(i,j):用第i个及其右边全部工厂，修理第j个及其右边的全部机器人，机器人移动的最小总距离。
//f(i,j) = mink{  f(i+1,k+1) + cost(i,j,k)  }
// cost(i,j,k) 表示 第i个工厂修复从j到k的机器人（包括k）的代价

//记忆化搜索
class hhjbhj {
    int n, m;
    //f[i][j]表示第i～n-1个工厂处理第j～m-1个机器人的代价总和
    long[][] f;
    long inf = (long) 1e13;
    List<Integer> robot;
    int[][] factory;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        this.robot = robot;
        this.factory = factory;
        robot.sort((a, b) -> a - b);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        n = factory.length;
        m = robot.size();
        f = new long[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], inf);
        return f(0, 0);
    }

    public long f(int i, int j) {
        //到达i工厂的时候，所有机器人已经处理完了，没有机器人了
        if (j == m) return 0;
        //最后一个工厂
        if (i == n - 1) {
            //当前剩余未处理机器人的个数大于最后一个工厂的limit，返回一个无穷大
            if (m - j > factory[i][1]) return inf;
            //否则，计算剩下的机器人到最后一个工厂的距离之和
            long res = 0;
            for (int k = j; k < m; k++) res += Math.abs(robot.get(k) - factory[i][0]);
            f[i][j] = res;
            return res;
        }
        //如果当前状态已经计算过就直接返回
        if (f[i][j] != inf) return f[i][j];

        //res初始化为  f[i][j]的可能值之一：当前工厂i不处理任何机器人的情况
        long res = f(i + 1, j);
        //dis记录当前工厂i处理的机器人的总代价
        long dis = 0;
        //枚举处当前工厂能处理1，2，3，4...个机器人的 所有情况
        for (int k = j; k < Math.min(m, j + factory[i][1]); k++) {
            dis += Math.abs(robot.get(k) - factory[i][0]);
            //当前工厂i已经处理完机器人k了，那么接下来的k+1机器人交给i+1工厂处理，最小距离为c，也即得到f[i+1][k+1]的值
            long c = f(i + 1, k + 1);
            res = Math.min(res, c + dis);
        }
        f[i][j] = res;
        return f[i][j];
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class _最小移动总距离 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        TreeMap<Integer, Integer> fac = new TreeMap<Integer, Integer>();
        int minfac = Integer.MAX_VALUE;
        int maxfac = Integer.MIN_VALUE;
        for (int i = 0; i < factory.length; i++) {
            if (factory[i][1] != 0) fac.put(factory[i][0], factory[i][1]);
            minfac = Math.min(minfac, factory[i][0]);
            maxfac = Math.max(maxfac, factory[i][0]);
        }
        long res = 0;
        for (int i = 0; i < robot.size(); i++) {
            if (robot.get(i) < minfac) {
                fac.put(minfac, fac.get(minfac) - 1);
                res += (minfac - robot.get(i));
                if (fac.get(minfac) == 0) {
                    fac.remove(minfac);
                    minfac = fac.higherKey(minfac);
                }
                robot.remove(i);
                i--;
            } else if (robot.get(i) > maxfac) {
                fac.put(maxfac, fac.get(maxfac) - 1);
                res += (robot.get(i) - maxfac);
                if (fac.get(maxfac) == 0) {
                    fac.remove(maxfac);
                    maxfac = fac.lowerKey(maxfac);
                }
                robot.remove(i);
                i--;
            }
        }
        for (int i = 0; i < robot.size(); i++) {
            int pos = robot.get(i);
            if (fac.containsKey(pos)) {
                fac.put(pos, fac.get(pos) - 1);
                if (fac.get(pos) == 0) fac.remove(pos);
                continue;
            }
            int up = Integer.MIN_VALUE;
            int down = Integer.MIN_VALUE;
            if (fac.lowerKey(pos) != null) down = fac.lowerKey(pos);
            if (fac.higherKey(pos) != null) up = fac.higherKey(pos);
            if (up != Integer.MIN_VALUE && down != Integer.MIN_VALUE) {
                if (up - pos >= pos - down) {
                    res += pos - down;
                    //
                    fac.put(down, fac.get(down) - 1);
                    if (fac.get(down) == 0) {
                        fac.remove(down);
                    }
                } else {
                    res += up - pos;
                    //
                    fac.put(up, fac.get(up) - 1);
                    if (fac.get(up) == 0) {
                        fac.remove(up);
                    }
                }
            } else if (up == Integer.MIN_VALUE) {
                res += pos - down;
                //
                fac.put(down, fac.get(down) - 1);
                if (fac.get(down) == 0) {
                    fac.remove(down);
                }
            } else {
                res += up - pos;
                //
                fac.put(up, fac.get(up) - 1);
                if (fac.get(up) == 0) {
                    fac.remove(up);
                }
            }
        }
        return res;
    }
}


