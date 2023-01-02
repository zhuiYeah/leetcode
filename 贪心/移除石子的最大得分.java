package 贪心;

import java.util.Arrays;
/**你正在玩一个单人游戏，面前放置着大小分别为 a、b 和 c  的 三堆 石子。

 每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。

 计算最大得分
 **/

public class 移除石子的最大得分 {
    public int maximumScore(int a, int b, int c) {
        int[] nums = new int[]{a, b, c};
        Arrays.sort(nums);
        int aa = nums[0], bb = nums[1], cc = nums[2];
        int res = 0;
        //bb , cc均摊 aa
        if (bb == cc) {
            bb -= aa / 2;
            cc -= aa / 2;
            res += aa / 2 * 2;
            res += bb;
            return res;
        }
        //aa全部和cc消消乐
        if (cc - bb >= aa) {
            cc -= aa;
            res += aa + bb;
            return res;
        }

        //aa与cc消消乐，消消乐到bb与cc相等之后 bb与cc均摊aa
        aa -= cc - bb;
        res += cc - bb;
        cc = bb;
        bb -= aa / 2;
        cc -= aa / 2;
        res += aa / 2 * 2;
        res += bb;
        return res;
    }
}
