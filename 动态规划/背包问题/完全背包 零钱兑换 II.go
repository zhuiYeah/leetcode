package 背包问题

//coins表示不同面额的硬币，amount表示要凑成的总数，硬币数目无限，凑出amount共有多少种方案？

//完全背包求装满背包的 组合 数 ： 先遍历物品 后 遍历背包容量（由小到大:这是为了保证有机会重复放入物品i）
//完全背包求装满背包的 排列 数 ： 先遍历背包容量（由小到大） 后 遍历物品

//有无限的物品coin[0]~coins[i],将这些物品装满容量为amount的背包，有几种装法（组合法）
func change(amount int, coins []int) int {
	dp := make([]int, amount+1) //dp[j]:对于从coins[0]~coins[i]任选任意数量，装满j背包共有dp[j]种方案
	// 当前遍历到coin[i],不放入物品i的话，装满j背包的方案不变（相对于i-1和i），dp[j]不变
	// 如果放入物品i的话，本来装满j背包共有dp[j]种方案，现在有dp[j]+dp[j-coins[i]]
	// 为了保证一个硬币可以重复放入，从左到右遍历背包容量，这样使用到的dp[j-coin[i]]（从0～i任取）可能已经放入i了

	//初始化dp数组
	dp[0] = 1 //一个硬币也不取凑成0，这也是一种方案
	for j := coins[0]; j <= amount; j++ {
		if j%coins[0] == 0 {
			dp[j] = 1
		}
	}
	//
	for i := 1; i < len(coins); i++ { //遍历物品
		for j := coins[i]; j <= amount; j++ { //(背包最小要能放下物品i)从小到大遍历背包，保证物品i能有多次放入的机会
			dp[j] += dp[j-coins[i]]
		}
	}
	return dp[amount]
}
