package 动态规划

func longestCommonSubsequence(text1 string, text2 string) int {
	dp := make([][]int, len(text1)+1)
	//dp[i][j]: 字符串text1[:i],text[:j],他们当前的最长公共子序列的长度为dp[i][j]
	//如果text1[i-1]==text2[j-1] 即找到了一个公共元素 ,dp[i][j]=dp[i-1][j-1]+1
	//如果text1[i-1]！=text2[j-1] ，dp[i][j]=max(dp[i-1][j],dp[i][j-1])
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(text2)+1)
	}
	//根据定义,dp[0][j] dp[i][0] 均为 0
	for i := 1; i < len(dp); i++ {
		for j := 1; j < len(dp[0]); j++ {
			if text1[i-1] == text2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	return dp[len(text1)][len(text2)]
}
