package 字符串

//返回s的最长回文子串

func longestPalindrome(s string) string {
	dp := make([][]bool, len(s))
	//dp[i][j] : [i:j]左闭右闭 是不是回文串 ？
	// if s[i]==s[j] && dp[i+1][j-1]==true  那么 dp[i][j]=true
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]bool, len(s))
	}
	//初始化dp数组
	for i := 0; i < len(dp); i++ {
		dp[i][i] = true
	}
	maxLength := 1
	var start, end int

	for i := len(s) - 1; i >= 0; i-- {
		for j := i + 1; j < len(s); j++ {
			if s[i] == s[j] {
				if j-i == 1 {
					dp[i][j] = true
				}
				if dp[i+1][j-1] == true {
					dp[i][j] = true
				}
			}
			if dp[i][j] == true && j-i+1 > maxLength {
				maxLength = j - i + 1
				start = i
				end = j
			}
		}
	}
	return s[start : end+1]
}
