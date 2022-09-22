package 动态规划

//nums数组的最长严格递增子序列

func lengthOfLIS(nums []int) int {
	dp := make([]int, len(nums)) //dp[i]:从nums0～numsi，且一定要选择nums[i],我的最长递增子序列长度为dp[i]
	//dp[i]如何计算：对于i之前的每一个元素j ，如果numsi>numsj,那么就可以新构成一个递增子序列，即dp[j]构成的递增子序列再加上numsi就构成了一个新的递增子序列
	//所以dp[i],应该取所有的dp[j]+1中的最大值

	//初始化dp数组
	for i := 0; i < len(dp); i++ {
		dp[i] = 1
	}
	res := 1
	for i := 1; i < len(dp); i++ { //遍历每一个数字
		for j := 0; j < i; j++ { //遍历当前数字之前的每一个数字
			if nums[i] > nums[j] {
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		if dp[i] > res {
			res = dp[i]
		}
	}

	return res
}
