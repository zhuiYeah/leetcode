package 动态规划

////s只包含'1'和'0'，返回使s单调递增的最小翻转次数
//func minFlipsMonoIncr(s string) int {
//	dpZero := make([]int, len(s))
//	//dpZero[i]:当前字符串下标为i，使得[0:i]递增且最后一位为0的最小翻转次数为dpZero[i]
//	//
//	dpOne := make([]int, len(s))
//	if s[0] == '0' {
//		dpZero[0] = 0
//	} else {
//		dpZero[0] = 1
//	}
//	for i := 1; i < len(s); i++ {
//		if s[i] == '1' {
//			dpZero[i] = dpZero[i-1] + 1
//		} else {
//			dpZero[i] = dpZero[i-1]
//		}
//	}
//	start := 0
//	for ; start < len(s); start++ {
//		if s[start] == '1' {
//			dpOne[start] = 0
//			break
//		}
//	}
//	for i := start + 1; i < len(s); i++ {
//		if s[i] == '0' {
//			dpOne[i] = dpOne[i-1] + 1
//		} else {
//			dpOne[i] = dpOne[i-1]
//		}
//	}
//	return min(dpZero[len(s)-1], dpOne[len(s)-1])
//}

//在经历了上面的错误案例后，立刻推导出了正确的动态规划转移方程
func minFlipsMonoIncr(s string) int {
	dp := make([][]int, len(s))
	//dp[i][0],以0作为递增字符串的结果，需要的翻转次数为dp[i][0] （其实就是把遇到的1全部翻转）
	//dp[i][1],以1作为递增字符串的结果，需要的翻转次数为dp[i][1]
	//if s[i]==1 ,dp[i][1] = min(dp[i-1][0],dp[i-1][1]) ,当前为1，前一个为0为1都可以，取翻转次数最少的
	//if s[i]==0 ,dp[i][1] = dp[i-1][1] + 1    当前为0，要翻转成1 ，
	for i := 0; i < len(s); i++ {
		dp[i] = make([]int, 2)
	}
	if s[0] == '0' {
		dp[0][0] = 0
		dp[0][1] = 1
	} else {
		dp[0][0] = 1
		dp[0][1] = 0
	}
	for i := 1; i < len(s); i++ {
		if s[i] == '0' {
			dp[i][0] = dp[i-1][0]
			dp[i][1] = dp[i-1][1] + 1
		} else {
			dp[i][0] = dp[i-1][0] + 1
			dp[i][1] = min(dp[i-1][0], dp[i-1][1])
		}
	}

	return min(dp[len(s)-1][0], dp[len(s)-1][1])
}
