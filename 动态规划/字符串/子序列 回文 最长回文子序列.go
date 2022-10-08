package 字符串

//给出s的最长回文子序列长度

func longestPalindromeSubseq(s string) int {
	dp := make([][]int, len(s))
	//dp[i][j]  s在左闭右闭区间[i:j]的最长回文子序列长度为dp[i][j]
	//如果 s[i]==s[j]  dp[i][j]= dp[i+1][j-1]+2
	//否则 dp[i][j] = max(dp[i+1][j],dp[i][j-1])
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(s))
	}
	//初始化dp数组
	for i := 0; i < len(dp); i++ {
		dp[i][i] = 1
	}
	n := len(s)
	for i := n - 1; i >= 0; i-- { //看递推公式就知道为什么从下往上遍历了
		for j := i + 1; j < n; j++ { //要保证j>n ,[i:j]
			if s[i] == s[j] {
				dp[i][j] = dp[i+1][j-1] + 2
			} else {
				dp[i][j] = max(dp[i+1][j], dp[i][j-1])
			}
		}
	}
	return dp[0][len(s)-1]
}
