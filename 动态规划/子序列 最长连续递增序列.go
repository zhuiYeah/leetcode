package 动态规划

func findLengthOfLCIS(nums []int) int {
	dp := make([]int, len(nums)) //dp[i]: 序列必须要选择nums[i],从nums0～numsi,最长连续递增序列的长度为dp[i]
	//if dp[i]>dp[i-1] 则dp[i]=dp[i-1]+1  else dp[i]=1
	dp[0] = 1
	res := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			dp[i] = dp[i-1] + 1
		} else {
			dp[i] = 1
		}
		if dp[i] > res {
			res = dp[i]
		}
	}
	return res
}
