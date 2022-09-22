package 动态规划;

public class 最佳观光组合 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxQuan = values[0]; //能为下一个景点提供的最大价值
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxQuan--; //能为下一个节点提供的价值随着距离递减
            int x = values[i] + maxQuan; //当前景点i必须去的话，所能得到的最大值
            if (values[i] > maxQuan) { //更新能为之后节点提供的最大价值
                maxQuan = values[i];
            }
            if (x > res) { //更新最佳组合
                res = x;
            }
        }
        return res;
    }
}
