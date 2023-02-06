package 贪心;


/**
 * 给你的coins数组表示你拥有的硬币
 * 如果可以从硬币中挑出任意的一部分，他们的和为x，那么称可以构造出x
 * 请返回从 0 开始（包括 0 ），你最多能 构造 出多少个连续整数。
 * <p>
 * 例如 ： coins = [1,3] ， 可以构造出 0  1 ,即两个连续整数
 * coins = [1,1,1,4] , 可以构造出 0 ～ 7
 */

import java.util.Arrays;

/**
 * 现在手中的硬币可以组成[0 : x] , 有新硬币面值为y ，加上新硬币（强制必须加入y），则可以组成[y : y + x]
 * 为了达成连续 ， 则必须达成 y <= x+1 (y - x <= 1)
 * 如果满足该条件的话，那么加上y，硬币可组成[0:x + y]
 * <p>
 * 初始为 [0:0] ，之后从小到大遍历所有的y，更新右边界
 */

//  思维  +  数学  +  贪心
public class 你能构造出连续值的最大数目 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int x = 0;
        for (int y : coins) {
            if (y - x > 1) break;
            x += y;
        }
        return x + 1;
    }
}
