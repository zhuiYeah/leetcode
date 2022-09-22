package 动态规划

import "math"

//和为 n 的完全平方数的最少数量 是多少

//完全背包问题 ： 背包容量为n，物品数量无限，从物品1^1 ，2^2， 3^3 ，... ,sqrt(n)^sqrt(n) ; 填满背包的最小物品数量为

func numSquares(n int) int {
	dp := make([]int, n+1) // dp[j] : 背包容量为j，从0～i物品任意放置，放满背包的最小物品数量为dp[j]

	//先背包后物品，先物品后背包都行
	//  j背包放入物品i：dp[j] = dp[j-物品i的重量(i*i)] + 1

	//初始化dp数组
	for j := 0; j <= n; j++ {
		dp[j] = j
	}

	x := int(math.Sqrt(float64(n)))

	for i := 1; i <= x; i++ { //遍历物品

		//当前是物品i
		//下面要决定背包j放不放物品i，放几个物品i
		for j := i * i; j <= n; j++ {
			dp[j] = min(dp[j], dp[j-i*i]+1)
		}
	}

	return dp[n]
}
