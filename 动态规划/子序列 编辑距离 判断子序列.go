package 动态规划

//s是t的子序列吗

//用双指针法解决
func isSubsequence(s string, t string) bool {
	if len(s) == 0 {
		return true
	}
	tp := 0 //tp指向t中的元素
	sp := 0 //sp指向s中的元素
	for tp < len(t) {
		if sp == len(s) {
			return true
		}
		if s[sp] == t[tp] {
			sp++
			tp++
		} else {
			tp++
		}
	}
	if sp == len(s) {
		return true
	} else {
		return false
	}
}

//正儿八经的动态规划
func isSubsequence0(s string, t string) bool {
	dp := make([][]int, len(s)+1)
	//dp[i][j] :当前s下标为i-1，t下标为j-1，当前的公共子序列长度为dp[i][j]
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(t)+1)
	}
	for i := 1; i < len(dp); i++ {
		for j := 1; j < len(dp[0]); j++ {
			if s[i-1] == t[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
				if dp[i][j] == len(s) {
					return true
				}
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	return false
}
