package 动态规划

//分割回文串I 用的是回溯法，那道题目要求必须给出所有的分割方案，但这题只要求给出最小分割次数

//两次动态规划
func minCut(s string) int {
	isPalindromic := make([][]bool, len(s))
	//isPalindromic[i][j] : [i:j]区间的子串是否为回文子串
	for i := 0; i < len(isPalindromic); i++ {
		isPalindromic[i] = make([]bool, len(s))
	}
	for i := len(s) - 1; i >= 0; i-- {
		for j := i; j < len(s); j++ {
			if j == i {
				isPalindromic[i][j] = true
				continue
			}
			if s[j] == s[i] {
				if j == 1+i {
					isPalindromic[i][j] = true
					continue
				}
				if isPalindromic[i+1][j-1] == true {
					isPalindromic[i][j] = true
				}
			}
		}
	}

	dp := make([]int, len(s)) //范围是[0：i]的子串，分割成回文子串，他的最小分割次数为dp[i]
	//求dp[i]  	如果[j+1:i]区间的串为回文串的话，那么dp[i]= dp[j]+1 (取所有dp[j]+1的最小值或dp[i])
	//初始化dp数组
	for i := 0; i < len(dp); i++ {
		dp[i] = i
	}
	for i := 1; i < len(dp); i++ {
		if isPalindromic[0][i] {
			dp[i] = 0
			break
		}
		for j := 0; j < i; j++ {
			if isPalindromic[j+1][i] {
				dp[i] = min(dp[i], dp[j]+1)
			}
		}
	}
	return dp[len(s)-1]
}
