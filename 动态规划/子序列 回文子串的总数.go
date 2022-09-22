package 动态规划

//字符串s的所有回文子串的数目

//我这自己写的DP甚至还不如暴力算法 笑了
func countSubstrings(s string) int {
	dp := make([]int, len(s)) //dp[i]：s[0:i+1]中  回文子串的数目为dp[i]
	dp[0] = 1
	for i := 1; i < len(s); i++ {
		count := 1
		for j := 0; j < i; j++ {
			if isP(s[j : i+1]) {
				count++
			}
		}
		dp[i] = dp[i-1] + count
	}
	return dp[len(s)-1]
}
func isP(s string) bool {
	for i := 0; i < len(s)/2; i++ {
		if s[i] != s[len(s)-1-i] {
			return false
		}
	}
	return true
}

//真正的动态规划
func countSubstrings1(s string) int {
	dp := make([][]bool, len(s))
	//dp[i][j] : 在区间[i:j]左闭右闭 ，是否是回文子串呢
	//如果 j>i && s[j]==s[i] && dp[i+1][j-1]==true  则dp[i][j]=true
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]bool, len(s))
	}
	n := len(s)
	res := len(s)
	//初始化dp数组
	for i := 0; i < n; i++ {
		dp[i][i] = true
	}

	for i := n - 1; i >= 0; i-- { //从下往上，从左到右遍历的原因，dp[i][j]的递推要用到dp[i+1][j-1]
		for j := i + 1; j < n; j++ {
			if s[j] == s[i] {
				if j-i == 1 {
					dp[i][j] = true
				}
				if dp[i+1][j-1] == true {
					dp[i][j] = true
				}
			}
			if dp[i][j] {
				res++
			}
		}
	}
	return res
}
