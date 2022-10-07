package 背包问题

import "math"

//背包容量为amount，每个物品的数量无限，求出装满背包的最少物品数量

//本题求钱币最小个数，那么钱币有顺序和没有顺序都可以，都不影响钱币的最小个数。
//
//所以本题并不强调集合是组合还是排列。
//
//那么本题的两个for循环的关系是：外层for循环遍历物品，内层for遍历背包或者外层for遍历背包，内层for循环遍历物品都是可以的！

func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1) // dp[i] :装满背包i，所需的最少物品数量为dp[i]

	dp[0] = 0
	//当前遍历到背包i，现在遍历全部的物品[0~j]
	//如果放入物品j的话，装满背包i所需的物品数量为dp[i-coin[j]]+1,这里 i-coins[j]背包可能已经放入物品j，所以能实现重复放入
	//如果不放入物品j的话，装满背包i所需的物品数量仍为dp[j]
	for i := 1; i <= amount; i++ {
		dp[i] = math.MaxInt32
	}

	//
	for i := 1; i <= amount; i++ { //遍历背包容量

		//当前背包容量为i
		for j := 0; j < len(coins); j++ { //遍历物品
			if coins[j] <= i {
				dp[i] = min(dp[i], dp[i-coins[j]]+1)
			}
		}
	}

	if dp[amount] >= math.MaxInt32 {
		return -1
	} else {
		return dp[amount]
	}

}
