package 动态规划

//这里还未能理解dp数组的含义

func minDistance11(word1 string, word2 string) int {
	dp := make([][]int, len(word1)+1)
	//dp[i][j]  :  对于word1[0:i]和word2[0:j] ，最少操作dp[i][j]步可以让他们完全相同
	//先画图，然后推出状态转移方程
	///dp[i][j]
	//如果word1[i-1]==word2[j-1] , 那么对于word1和word2新增的字符串，是不需要任何处理滴 ，dp[i][j]=dp[i-1][j-1]
	///如果word[i-1] != word[j-1] ,
	//可以在dp[i-1][j]和dp[i][j-1]的基础上删掉一个新增的字符串 dp[i-1][j]+1 or dp[i][j-1]+1
	//，也可以在dp[i-1][j-1]的基础上更改一个字符串, dp[i-1]][j-1]+1
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(word2)+1)
	}
	//初始化dp数组
	for i := 0; i <= len(word1); i++ {
		dp[i][0] = i
	}
	for j := 0; j <= len(word2); j++ {
		dp[0][j] = j
	}
	//
	for i := 1; i < len(dp); i++ {
		for j := 1; j < len(dp[0]); j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1
			}
		}
	}
	return dp[len(word1)][len(word2)]

}
