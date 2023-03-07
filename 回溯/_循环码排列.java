package 回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 一共有n个bit位
 * 给出一个数组，相邻位二进制表示形式必须只有一位不同 （异或运算后只剩1bit的1，其余都是0）
 * 首尾的二进制表示形式也只有一位不同
 */

//超时

//超时 算法设计有问题，这种排列本身不存在递增递减的规律
public class _循环码排列 {


    public List<Integer> circularPermutation(int n, int start) {
        List<Integer>[] all = new List[n + 1];  //all[i]是一个list ，表示n个bit位，i个为1 的所有表示
        var set = new HashSet<Integer>();
        set.add(1 << 0);
        set.add(1 << 1);
        set.add(1 << 2);
        set.add(1 << 3);
        set.add(1 << 4);
        set.add(1 << 5);
        set.add(1 << 6);
        set.add(1 << 7);
        set.add(1 << 8);
        set.add(1 << 9);
        set.add(1 << 10);
        set.add(1 << 11);
        set.add(1 << 12);
        set.add(1 << 13);
        set.add(1 << 14);
        set.add(1 << 15);
        set.add(1 << 16);
        var res = new ArrayList<Integer>();
        for (int i = 0; i < n + 1; i++) all[i] = new ArrayList<Integer>();
        res.add(start);
        for (int i = 0; i <= (int) Math.pow(2, n) - 1; i++) {
            if (i == start) continue;
            int cnt = countOneBit(i);
            all[cnt].add(i);
        }
        int[] cnt = new int[n + 1];
        for (int i = 0; i <= n; i++) cnt[i] = all[i].size();
        int precnt = countOneBit(start);
        boolean flag = true; //flag为true表示下一个数字的1bit位要变多，否则表示1bit位要变少
        if (precnt == n) flag = false;
        while (res.size() != (int) Math.pow(2, n)) {
            //当前要比前一个位置递增
            if (flag) {
                int curcnt = precnt + 1, prenum = res.get(res.size() - 1);
                //找到了1bit数为curcnt的数字，并处理 all[curcnt]和cnt[curcnt]数组
                for (int i = 0; i < all[curcnt].size(); i++) {
                    if (!set.contains(all[curcnt].get(i) ^ prenum)) continue;
                    res.add(all[curcnt].get(i));
                    all[curcnt].remove(i);
                    cnt[curcnt]--;
                    break;
                }
                precnt++;
                //判断下一个应该递增还是递减
                if (curcnt == n || cnt[curcnt + 1] == 0) flag = false;

            } else { //递减
                int curcnt = precnt - 1, prenum = res.get(res.size() - 1);
                //找到了1bit数为curcnt的数字，并处理 all[curcnt]和cnt[curcnt]数组
                for (int i = 0; i < all[curcnt].size(); i++) {
                    if (!set.contains(all[curcnt].get(i) ^ prenum)) continue;
                    res.add(all[curcnt].get(i));
                    all[curcnt].remove(i);
                    cnt[curcnt]--;
                    break;
                }
                precnt--;
                //判断下一个应该递增还是递减
                if (curcnt == 0 || cnt[curcnt - 1] == 0) flag = true;
            }
        }
        return res;

    }

    //检查两数是否只有一个bit位不同
    private boolean only1bitAfterXOR(int a, int b) {
        int num = a ^ b;
        int cnt = 0;
        if (num == 0) return false; //全部相同
        while (num != 0) {
            cnt += num & 1;
            if (cnt >= 2) return false;
            num >>>= 1;
        }
        return cnt == 1;
    }

    //计算一个整数的二进制表示中，1的个数
    private int countOneBit(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += n & 1;
            n >>>= 1;
        }
        return cnt;
    }
}

class dewdew {
    public static void main(String[] args) {
        new _循环码排列().circularPermutation(2, 3);
    }
}

/**
 * 位运算 + 回溯
 */
//回溯的深度最多是6000 ， 宽度最多是16，所以不会超时
class 循环码排列1 {

    int N;
    boolean flag = false; //标记是否找到一条合适的路径
    List<Integer> path;
    Set<Integer> set = new HashSet<Integer>();
    boolean[] used;


    public List<Integer> circularPermutation(int n, int start) {
        N = n;
        set.add(1 << 0);
        set.add(1 << 1);
        set.add(1 << 2);
        set.add(1 << 3);
        set.add(1 << 4);
        set.add(1 << 5);
        set.add(1 << 6);
        set.add(1 << 7);
        set.add(1 << 8);
        set.add(1 << 9);
        set.add(1 << 10);
        set.add(1 << 11);
        set.add(1 << 12);
        set.add(1 << 13);
        set.add(1 << 14);
        set.add(1 << 15);
        set.add(1 << 16);
        path = new ArrayList<>();
        path.add(start);
        used = new boolean[1 << N];
        used[start] = true;
        backtracking(start);
        return path;

    }

    private void backtracking(int prev) {
        if (path.size() == 1 << N) {
            int a = path.get(0), b = path.get(path.size() - 1);
            if (set.contains(a ^ b)) flag = true;
            return;
        }
        //根据prev枚举全部的当前可能数字cur  异或运算
        for (int i = 0; i < N; i++) {
            int mask = 1 << i;
            int cur = prev ^ mask;
            if (used[cur]) continue;
            used[cur] = true;
            path.add(cur);
            backtracking(cur);
            if (flag) return;
            path.remove(path.size() - 1);
            used[cur] = false;
        }
    }
}


class 回溯2 {
    int N;
    List<Integer> path;
    Set<Integer> set = new HashSet<Integer>();
    boolean[] used;


    public List<Integer> circularPermutation(int n, int start) {
        N = n;
        set.add(1 << 0);
        set.add(1 << 1);
        set.add(1 << 2);
        set.add(1 << 3);
        set.add(1 << 4);
        set.add(1 << 5);
        set.add(1 << 6);
        set.add(1 << 7);
        set.add(1 << 8);
        set.add(1 << 9);
        set.add(1 << 10);
        set.add(1 << 11);
        set.add(1 << 12);
        set.add(1 << 13);
        set.add(1 << 14);
        set.add(1 << 15);
        set.add(1 << 16);
        path = new ArrayList<>();
        path.add(start);
        used = new boolean[1 << N];
        used[start] = true;
        backtracking(start);
        return path;

    }

    private boolean backtracking(int prev) {
        if (path.size() == 1 << N) {
            int a = path.get(0), b = path.get(path.size() - 1);
            return set.contains(a ^ b);
        }
        //根据prev枚举全部的当前可能数字cur  异或运算
        for (int i = 0; i < N; i++) {
            int mask = 1 << i;
            int cur = prev ^ mask;
            if (used[cur]) continue;
            used[cur] = true;
            path.add(cur);
            if (backtracking(cur)) return true;
            path.remove(path.size() - 1);
            used[cur] = false;
        }
        return false;
    }
}