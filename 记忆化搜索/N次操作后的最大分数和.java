package 记忆化搜索;


//一个长为 2*n 的数组，对他进行n次操作 ， 每次操作从数组中选择两个数a，b（选过的数字不能重复选）
// 每次操作的得分为 i*(gcd(a，b))，计算n次操作后的最大得分

import java.util.ArrayList;
import java.util.Arrays;


//状态压缩 + 记忆化搜索 + 回溯
public class N次操作后的最大分数和 {
    int N;
    int[][] f; //f[mask][n] ：在携带mask掩码的情况下，第n次操作所能得到的最大得分，1<=n<=N
    int[] nums;

    public int maxScore(int[] nums) {
        this.nums = nums;
        int N = nums.length / 2;
        //选择了全部数字的掩码
        int mask = (1 << 2 * N) - 1;
        f = new int[1 << (2 * N)][N + 1];
        //mask为0，表示什么都没选，得分为0
        Arrays.fill(f[0], 0);
        for (int i = 1; i < 1 << 2 * N; i++)
            Arrays.fill(f[i], -1);
        return f(mask, N);
    }

    private int f(int mask, int n) {
        if (n == 0) return 0;
        if (f[mask][n] != -1) return f[mask][n];
        int ans = 0;
        //list存放全部可以选择的数字的下标
        var list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) if (((1 << (nums.length - i - 1)) & mask) != 0) list.add(i);
        //res存放本层可以选择的两个下标
        var res = new ArrayList<int[]>();
        var path = new int[]{-1, -1};
        get2(list, 0, res, path);
        for (int i = 0; i < res.size(); i++) {
            int idx1 = res.get(i)[0];
            int idx2 = res.get(i)[1];
            mask = mask - (1 << nums.length - 1 - idx1) - (1 << nums.length - 1 - idx2);
            ans = Math.max(ans, n * gcd(nums[idx1], nums[idx2]) + f(mask, n - 1));
            mask += (1 << nums.length - 1 - idx1) + (1 << nums.length - 1 - idx2);
        }
        f[mask][n] = ans;
        return ans;
    }

    //回溯，从list中挑出两个数
    public void get2(ArrayList<Integer> list, int idx, ArrayList<int[]> res, int[] path) {
        if (idx == list.size()) return;
        //不选择idx
        get2(list, idx + 1, res, path);
        //选择idx
        if (path[0] == -1) {
            path[0] = list.get(idx);
            get2(list, idx + 1, res, path);
            path[0] = -1;
        } else {
            path[1] = list.get(idx);
            res.add(new int[]{path[0], path[1]});
            var tmp = path[0];
            path[0] = -1;
            path[1] = -1;
            get2(list, idx + 1, res, path);
            path[0] = tmp;
            path[1] = -1;
        }
    }

    private int gcd(int a, int b) {
        while (a % b != 0) {
            var tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }
}


class decee {
    public static void main(String[] args) {
        var x = new N次操作后的最大分数和().maxScore(new int[]{3, 4, 6, 8});
        System.out.println(x);
    }
}
