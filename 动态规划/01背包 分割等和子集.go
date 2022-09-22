package 动态规划

//正整数数组nums能否分割为两个等和子集

//转换为01背包问题：背包容量为 数组元素和/2 ，要放的物品i，价值为nums[i],重量也为nums[i]
//能否把背包恰好放满

func canPartition(nums []int) bool {
	var bagCapacity int
	for i := 0; i < len(nums); i++ {
		bagCapacity += nums[i]
	}
	if bagCapacity%2 == 1 {
		return false
	}
	bagCapacity /= 2

	dp := make([]int, bagCapacity+1) //dp[j] : 背包容量为j时，背包能装的最大重量是dp[j] （从nums[]数组里面的所有元素选择）

	//对于物品i，你的选择只有装进背包和不装进背包，（当前背包容量为j）
	//装进背包时，背包此时装的重量为 dp[j-nums[i]]+nums[i]
	//不装进背包时，背包此时的重量为 dp[j]
	//dp[j] = max(dp[j],dp[j-nums[i]]+nums[i])

	//初始化dp数组
	for j := len(dp) - 1; j >= nums[0]; j-- { //只能取物品0的情况下，如果背包放的下物品0（j>=nums[0]），那么dp[j]
		dp[j] = nums[0]
	}

	//
	for i := 1; i < len(nums); i++ { //遍历物品
		for j := bagCapacity; j > 0; j-- { //遍历背包
			if j < nums[i] {
				dp[j] = dp[j]
			} else {
				dp[j] = max(dp[j], dp[j-nums[i]]+nums[i])
			}
		}
	}

	return dp[bagCapacity] == bagCapacity //背包有没有被填满

}
