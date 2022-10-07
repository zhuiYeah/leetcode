package 字符串

//每一步可以删除一个字符，找到使得word1和word2完全相同的最短步数

func minDistance(word1 string, word2 string) int {
	dp := make([][]int, len(word1)+1)
	//dp[i][j] : 使得word1[0：i]和word2[0：j]相同的最短步数
	//如果 word1[i-1]==word2[j-1] 则dp[i][j]=dp[i-1][j-1]
	//如果 word1[i-1]！=word2[j-1]  则dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + 1 (靠画表推理出来的)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(word2)+1)
	}

	// 初始化dp数组
	for j := 0; j <= len(word2); j++ {
		dp[0][j] = j
	}
	for i := 0; i <= len(word1); i++ {
		dp[i][0] = i
	}

	for i := 1; i < len(dp); i++ {
		for j := 1; j < len(dp[0]); j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = min(dp[i][j-1], dp[i-1][j]) + 1
			}
		}
	}

	return dp[len(word1)][len(word2)]
}

//利用最长公共子序列
func minDistance1(word1 string, word2 string) int {
	dp := make([][]int, len(word1)+1)
	//dp[i][j] : word1[0:i] 和 word2[0:j] 的最长公共子序列为dp[i][j]
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(word2)+1)
	}
	for i := 1; i < len(dp); i++ {
		for j := 1; j < len(dp[0]); j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	return len(word2) + len(word1) - 2*dp[len(word1)][len(word2)]
}

func max(i int, j int) int {
	if i > j {
		return i
	} else {
		return j
	}
}
