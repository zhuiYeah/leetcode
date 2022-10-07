package 背包问题

//重复使用物品nums[],填满背包target。填满背包的排列数一共有多少

//完全背包求装满背包的 组合 数 ： 先遍历物品 后 遍历背包容量（由小到大:这是为了保证有机会重复放入物品i）
//完全背包求装满背包的 排列 数 ： 先遍历背包容量（由小到大） 后 遍历物品

func combinationSum4(nums []int, target int) int {
	dp := make([]int, target+1) // dp[i] : 背包容量为i时，填满背包的排列有dp[i]种
	//当前遍历到背包i，对于物品0～物品j～物品n
	// 放入物品j之后新增的排列数 dp[i-nums[j]]
	//所以 排列总数 为 dp[i]+dp[i-nums[j]]

	dp[0] = 1

	for i := 1; i <= target; i++ { //遍历背包
		//当前背包容量为i
		for j := 0; j < len(nums); j++ { //遍历物品 （每个容量的背包都可以放入物品i：保证了物品i的可多次放入；物品放在内循环，保证了物品的顺序可以逆序出现，这就是排列总和的含义所在）
			if i >= nums[j] {
				dp[i] += dp[i-nums[j]]
			}
		}
	}

	return dp[target]
}
