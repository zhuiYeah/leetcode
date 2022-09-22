package 动态规划

import "math"

//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

func integerBreak(n int) int {
	dp := make([]int, n+1) // dp[i]:拆分数字i，可以得到的最大乘积为 dp[i]
	//递推公式：j:from 1 to i-2 ; dp[i] = max(dp[i] ,j*(i-j) , j*dp[i-j])
	//初始化dp数组
	dp[2] = 1
	//
	for i := 3; i <= n; i++ {
		for j := 1; j <= i-2; j++ {
			dp[i] = max3(dp[i], j*(i-j), j*dp[i-j])
		}
	}
	return dp[len(dp)-1]
}

func max3(a, b, c int) int {
	if a >= b && a >= c {
		return a
	}
	if b >= a && b >= c {
		return b
	}
	if c >= a && c >= b {
		return c
	}

	return math.MaxInt32
}
