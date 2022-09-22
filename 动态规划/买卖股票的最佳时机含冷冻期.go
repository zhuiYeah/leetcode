package 动态规划

import "sort"

//卖出的第二天是冷冻期，你不能进行买入操作

func maxProfit5(prices []int) int {
	dp := make([][]int, len(prices))
	//dp[i][j] ：当前是第i天，当前状态为j，手中的最大金额为dp[i][j]
	//状态0：手中持有股票状态，要么是第i天买入的，要么就是之前已经买入的
	//状态1:当天卖出了股票
	//状态2：两天前或更久以前就卖出了口罩，今天仍保持手上没有股票
	//状态3：当天是冷冻期 冷冻期不可持续
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 4)
	}
	///dp[i][0]
	//1⃣️ 当天买入 ，可从i-1天的状态3和状态2转换而来  dp[i-1][3]-prices[i]   dp[i-1][2]-prices[i]   2⃣️继承i-1天已经持有股票的情况dp[i-1][0]
	///dp[i][1]
	//仅可由i-1的状态0转换而来  dp[i-1][0]+prices[i]
	///dp[i][2]
	//可由i-1的状态3和状态2转换而来 dp[i-1][3]  dp[i-1][2]
	///dp[i][3]
	//仅可由i-1的状态1转换而来 dp[i-1][1]

	//初始化dp数组
	dp[0][0] = -prices[0]

	for i := 1; i < len(dp); i++ { //遍历天数
		dp[i][0] = max(max(dp[i-1][3]-prices[i], dp[i-1][2]-prices[i]), dp[i-1][0])
		dp[i][1] = dp[i-1][0] + prices[i]
		dp[i][2] = max(dp[i-1][3], dp[i-1][2])
		dp[i][3] = dp[i-1][1]
	}
	x := dp[len(dp)-1]
	sort.Ints(x)
	return x[3]
}

//优化空间复杂度
func maxProfit55(prices []int) int {
	dp := make([]int, 4)
	dp[0] = -prices[0]
	for i := 0; i < len(prices); i++ {
		x0 := dp[0]
		dp[0] = max(max(dp[3]-prices[i], dp[2]-prices[i]), dp[0])
		dp[2] = max(dp[3], dp[2])
		dp[3] = dp[1]
		dp[1] = x0 + prices[i]
	}
	sort.Ints(dp)
	return dp[3]
}
